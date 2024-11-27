package com.tallerDeMotos.cliente.application.create;

import com.tallerDeMotos.cliente.domain.dto.ClienteDTO;
import com.tallerDeMotos.cliente.domain.entity.Cliente;
import com.tallerDeMotos.cliente.domain.exception.ClienteDuplicateDniException;
import com.tallerDeMotos.cliente.infrastructure.mapper.ClienteMapper;
import com.tallerDeMotos.cliente.infrastructure.repository.ClienteRepository;
import com.tallerDeMotos.motocicletas.domain.dto.MotocicletaDTO;
import com.tallerDeMotos.motocicletas.domain.entity.Motocicleta;
import com.tallerDeMotos.motocicletas.domain.exception.MotocicletaDominioDuplicatedException;
import com.tallerDeMotos.motocicletas.infrastructure.mapper.MotocicletaMapper;
import com.tallerDeMotos.motocicletas.infrastructure.repository.MotocicletaRepository;
import com.tallerDeMotos.ordenDeTrabajo.domain.dto.OrdenDeTrabajoDTO;
import com.tallerDeMotos.ordenDeTrabajo.domain.entity.OrdenDeTrabajo;
import com.tallerDeMotos.ordenDeTrabajo.infrastructure.mapper.OrdenDeTrabajoMapper;
import com.tallerDeMotos.ordenDeTrabajo.infrastructure.repository.OrdenDeTrabajoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ClienteCreatorImpl implements ClienteCreator{
    private final ClienteRepository clienteRepository;
    private final MotocicletaRepository motocicletaRepository;
    private final ClienteMapper clienteMapper;
    private final MotocicletaMapper motocicletaMapper;
    private final OrdenDeTrabajoMapper ordenDeTrabajoMapper;
    private final OrdenDeTrabajoRepository ordenDeTrabajoRepository;

    // Inyección por constructor
    public ClienteCreatorImpl(ClienteRepository clienteRepository,
                              MotocicletaRepository motocicletaRepository,
                              ClienteMapper clienteMapper,
                              MotocicletaMapper motocicletaMapper,
                              OrdenDeTrabajoMapper ordenDeTrabajoMapper,
                              OrdenDeTrabajoRepository ordenDeTrabajoRepository) {
        this.clienteRepository = clienteRepository;
        this.motocicletaRepository = motocicletaRepository;
        this.clienteMapper = clienteMapper;
        this.motocicletaMapper = motocicletaMapper;
        this.ordenDeTrabajoMapper = ordenDeTrabajoMapper;
        this.ordenDeTrabajoRepository = ordenDeTrabajoRepository;
    }

    @Override
    @Transactional
    public ClienteDTO createCliente(ClienteDTO clienteDTO) throws ClienteDuplicateDniException, MotocicletaDominioDuplicatedException {

        // Validar si el cliente con el mismo DNI ya existe
        Optional<Cliente> existingCliente = clienteRepository.findByDni(clienteDTO.getDni());
        if (existingCliente.isPresent()) {
            String customMessage = "El cliente con el DNI " + clienteDTO.getDni() + " ya existe.";
            throw new ClienteDuplicateDniException(customMessage);  // Pasamos el mensaje personalizado
        }
        // Convertir el DTO de cliente a entidad de dominio (Cliente)
        Cliente cliente = clienteMapper.toEntity(clienteDTO);

        // Guardar el cliente (que es una entidad de dominio)
        clienteRepository.save(cliente);

        // Crear las motocicletas asociadas al cliente
        if (clienteDTO.getMotocicletas() != null) {
            for (MotocicletaDTO motocicletaDTO : clienteDTO.getMotocicletas()) {
                // Validar si ya existe una motocicleta con el mismo dominio
                Optional<Motocicleta> existingMotocicleta = motocicletaRepository.findMotocicletaByDominio(motocicletaDTO.getDominio());
                if (existingMotocicleta.isPresent()) {
                    throw new MotocicletaDominioDuplicatedException();  // Excepción personalizada para dominio duplicado
                }

                    // Convertir el DTO de motocicleta a entidad persistente
                Motocicleta motocicleta = motocicletaMapper.toEntity(motocicletaDTO);

                // Asignar el cliente al que pertenece la motocicleta
                motocicleta.setCliente(cliente);

                // Guardar la motocicleta
                motocicletaRepository.save(motocicleta);

                // Crear las órdenes de trabajo asociadas a la motocicleta
                if (motocicletaDTO.getOrdenesDeTrabajo() != null) {
                    for (OrdenDeTrabajoDTO ordenDeTrabajoDTO : motocicletaDTO.getOrdenesDeTrabajo()) {
                        // Convertir el DTO de la orden de trabajo a entidad
                        OrdenDeTrabajo ordenDeTrabajo = ordenDeTrabajoMapper.toEntity(ordenDeTrabajoDTO);

                        // Asignar la motocicleta a la orden de trabajo
                        ordenDeTrabajo.setMotocicleta(motocicleta);

                        // Guardar la orden de trabajo
                        ordenDeTrabajoRepository.save(ordenDeTrabajo);
                    }
                }
            }
        }

        // Devolver el DTO del cliente con las motocicletas asociadas
        return clienteMapper.toDTO(cliente);
    }
}


