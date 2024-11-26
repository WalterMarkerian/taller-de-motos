package com.tallerDeMotos.ordenDeTrabajo.application.create;

import com.tallerDeMotos.motocicletas.domain.dto.MotocicletaDTO;
import com.tallerDeMotos.motocicletas.domain.entity.Motocicleta;
import com.tallerDeMotos.motocicletas.domain.exception.MotocicletasNotFoundException;
import com.tallerDeMotos.motocicletas.infrastructure.repository.MotocicletaRepository;
import com.tallerDeMotos.ordenDeTrabajo.domain.dto.OrdenDeTrabajoDTO;
import com.tallerDeMotos.ordenDeTrabajo.domain.entity.OrdenDeTrabajo;
import com.tallerDeMotos.ordenDeTrabajo.domain.exception.OrdenDeTrabajoDuplicateIdException;
import com.tallerDeMotos.ordenDeTrabajo.infrastructure.mapper.OrdenDeTrabajoMapper;
import com.tallerDeMotos.ordenDeTrabajo.infrastructure.repository.OrdenDeTrabajoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrdenDeTrabajoCreatorImpl implements OrdenDeTrabajoCreater {
    private OrdenDeTrabajoRepository ordenDeTrabajoRepository;
    private MotocicletaRepository motocicletaRepository;
    private OrdenDeTrabajoMapper ordenDeTrabajoMapper;

    public OrdenDeTrabajoCreatorImpl(OrdenDeTrabajoRepository ordenDeTrabajoRepository,
                                     MotocicletaRepository motocicletaRepository,
                                     OrdenDeTrabajoMapper ordenDeTrabajoMapper) {
        this.ordenDeTrabajoRepository = ordenDeTrabajoRepository;
        this.motocicletaRepository = motocicletaRepository;
        this.ordenDeTrabajoMapper = ordenDeTrabajoMapper;
    }

    @Override
    @Transactional
    public OrdenDeTrabajoDTO createOrdenDeTrabajo(OrdenDeTrabajoDTO ordenDeTrabajoDTO)
            throws OrdenDeTrabajoDuplicateIdException, MotocicletasNotFoundException {

        // Verifica si ya existe una orden de trabajo con el mismo ID
        if (ordenDeTrabajoRepository.existsByOrdenDeTrabajoId(ordenDeTrabajoDTO.getOrdenDeTrabajoId())) {
            throw new OrdenDeTrabajoDuplicateIdException(); // Lanza una excepción si ya existe una orden con el mismo ID
        }

        // Verificar si la motocicleta con el ID proporcionado existe en la base de datos
        if (!motocicletaRepository.existsByMotocicletaId(ordenDeTrabajoDTO.getMotocicletaId())) {
            throw new MotocicletasNotFoundException(); // Lanza una excepción si la motocicleta no se encuentra
        }

        // Convertir el DTO de la orden de trabajo a la entidad de dominio
        OrdenDeTrabajo ordenDeTrabajo = ordenDeTrabajoMapper.toEntity(ordenDeTrabajoDTO);

        // Obtener la motocicleta correspondiente usando el ID
        Motocicleta motocicleta = motocicletaRepository.findByMotocicletaId(ordenDeTrabajoDTO.getMotocicletaId())
                .orElseThrow(() -> new MotocicletasNotFoundException()); // Si no se encuentra la motocicleta, lanzar excepción

        // Asociar la motocicleta con la orden de trabajo
        ordenDeTrabajo.setMotocicleta(motocicleta); // Establecer la motocicleta en la orden de trabajo

        // Guardar la orden de trabajo en la base de datos
        OrdenDeTrabajo savedOrdenDeTrabajoEntity = ordenDeTrabajoRepository.save(ordenDeTrabajo);

        // Convertir la entidad guardada a DTO y devolverlo
        return ordenDeTrabajoMapper.toDTO(savedOrdenDeTrabajoEntity); // Convertir la entidad guardada de vuelta a un DTO
    }
}