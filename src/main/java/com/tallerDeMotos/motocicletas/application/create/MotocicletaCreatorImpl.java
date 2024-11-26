package com.tallerDeMotos.motocicletas.application.create;

import com.tallerDeMotos.cliente.domain.entity.Cliente;
import com.tallerDeMotos.cliente.domain.exception.ClienteNotFoundException;
import com.tallerDeMotos.cliente.infrastructure.repository.ClienteRepository;
import com.tallerDeMotos.motocicletas.domain.dto.MotocicletaDTO;
import com.tallerDeMotos.motocicletas.domain.entity.Motocicleta;
import com.tallerDeMotos.motocicletas.domain.exception.MotocicletaDominioDuplicatedException;
import com.tallerDeMotos.motocicletas.infrastructure.mapper.MotocicletaMapper;
import com.tallerDeMotos.motocicletas.infrastructure.repository.MotocicletaRepository;
import com.tallerDeMotos.ordenDeTrabajo.domain.entity.OrdenDeTrabajo;
import com.tallerDeMotos.ordenDeTrabajo.infrastructure.mapper.OrdenDeTrabajoMapper;
import com.tallerDeMotos.ordenDeTrabajo.infrastructure.repository.OrdenDeTrabajoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MotocicletaCreatorImpl implements MotocicletaCreator {
    private MotocicletaRepository motocicletaRepository;
    private MotocicletaMapper motocicletaMapper;
    private OrdenDeTrabajoMapper ordenDeTrabajoMapper;
    private ClienteRepository clienteRepository;
    private OrdenDeTrabajoRepository ordenDeTrabajoRepository;

    public MotocicletaCreatorImpl(MotocicletaRepository motocicletaRepository,
                                  MotocicletaMapper motocicletaMapper,
                                  OrdenDeTrabajoMapper ordenDeTrabajoMapper,
                                  ClienteRepository clienteRepository,
                                  OrdenDeTrabajoRepository ordenDeTrabajoRepository) {
        this.motocicletaRepository = motocicletaRepository;
        this.motocicletaMapper = motocicletaMapper;
        this.ordenDeTrabajoMapper = ordenDeTrabajoMapper;
        this.clienteRepository = clienteRepository;
        this.ordenDeTrabajoRepository = ordenDeTrabajoRepository;
    }

    @Override
    @Transactional
    public MotocicletaDTO createMoto(MotocicletaDTO motocicletaDTO) throws MotocicletaDominioDuplicatedException, ClienteNotFoundException {
        // Verifica si ya existe una motocicleta con el mismo dominio (patente)
        if (motocicletaRepository.existsByDominio(motocicletaDTO.getDominio())) {
            throw new MotocicletaDominioDuplicatedException();
        }

        // Obtiene el cliente asociado a la motocicleta
        Cliente cliente = clienteRepository.findById(motocicletaDTO.getClienteId())
                .orElseThrow(() -> new ClienteNotFoundException());

        // Mapea el DTO de motocicleta a un objeto de dominio
        Motocicleta motocicleta = motocicletaMapper.toEntity(motocicletaDTO);

        // Asigna el cliente a la entidad de la motocicleta
        motocicleta.setCliente(cliente);

        // Si la motocicleta tiene órdenes de trabajo, las asignamos
        if (motocicletaDTO.getOrdenesDeTrabajo() != null && !motocicletaDTO.getOrdenesDeTrabajo().isEmpty()) {
            // Mapea las órdenes de trabajo desde el DTO a la entidad y las asocia
            List<OrdenDeTrabajo> ordenesDeTrabajoEntities = motocicletaDTO.getOrdenesDeTrabajo().stream()
                    .map(ordenDTO -> {
                        // Mapear cada orden de trabajo y asociarla con la motocicleta
                        OrdenDeTrabajo ordenEntity = ordenDeTrabajoMapper.toEntity(ordenDTO);
                        ordenEntity.setMotocicleta(motocicleta); // Asociar la orden con la motocicleta
                        return ordenEntity;
                    })
                    .collect(Collectors.toList());

            // Asignar las órdenes de trabajo a la entidad de la motocicleta
            motocicleta.setOrdenesDeTrabajo(ordenesDeTrabajoEntities);
        }

        // Guarda la entidad de la motocicleta en la base de datos
        Motocicleta savedMotocicletaEntity = motocicletaRepository.save(motocicleta);

        // Retorna el DTO de la motocicleta guardada
        return motocicletaMapper.toDTO(savedMotocicletaEntity);
    }
}
