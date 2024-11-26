package com.tallerDeMotos.ordenDeTrabajo.infrastructure.mapper;

import com.tallerDeMotos.ordenDeTrabajo.domain.dto.OrdenDeTrabajoDTO;
import com.tallerDeMotos.ordenDeTrabajo.domain.entity.OrdenDeTrabajo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface OrdenDeTrabajoMapper {

    OrdenDeTrabajoMapper INSTANCE = Mappers.getMapper(OrdenDeTrabajoMapper.class);

    // Mapea de OrdenDeTrabajo a OrdenDeTrabajoDTO
    @Mapping(source = "ordenDeTrabajoId", target = "ordenDeTrabajoId")
    @Mapping(source = "descripcion", target = "descripcion")
    @Mapping(source = "monto", target = "monto")
    @Mapping(source = "altaOrden", target = "altaOrden")
    @Mapping(source = "estado", target = "estado")
    @Mapping(source = "motocicleta.motocicletaId", target = "motocicletaId")
    OrdenDeTrabajoDTO toDTO(OrdenDeTrabajo ordenDeTrabajo);

    // Mapea de OrdenDeTrabajoDTO a OrdenDeTrabajo
    @Mapping(source = "ordenDeTrabajoId", target = "ordenDeTrabajoId")
    @Mapping(source = "descripcion", target = "descripcion")
    @Mapping(source = "monto", target = "monto")
    @Mapping(source = "altaOrden", target = "altaOrden")
    @Mapping(source = "estado", target = "estado")
    @Mapping(source = "motocicletaId", target = "motocicleta.motocicletaId")
    OrdenDeTrabajo toEntity(OrdenDeTrabajoDTO ordenDeTrabajoDTO);
}
