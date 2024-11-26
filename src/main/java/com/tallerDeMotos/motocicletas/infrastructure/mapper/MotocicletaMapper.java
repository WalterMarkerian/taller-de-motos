package com.tallerDeMotos.motocicletas.infrastructure.mapper;

import com.tallerDeMotos.motocicletas.domain.dto.MotocicletaDTO;
import com.tallerDeMotos.motocicletas.domain.entity.Motocicleta;
import com.tallerDeMotos.ordenDeTrabajo.infrastructure.mapper.OrdenDeTrabajoMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring", uses = OrdenDeTrabajoMapper.class)
public interface MotocicletaMapper {

    MotocicletaMapper INSTANCE = Mappers.getMapper(MotocicletaMapper.class);

    // Mapea de Motocicleta a MotocicletaDTO
    @Mapping(source = "motocicletaId", target = "motocicletaId")
    @Mapping(source = "dominio", target = "patente")
    @Mapping(source = "marca", target = "marca")
    @Mapping(source = "modelo", target = "modelo")
    @Mapping(source = "cilindrada", target = "cilindrada")
    @Mapping(source = "chasis", target = "chasis")
    @Mapping(source = "kilometraje", target = "kilometraje")
    @Mapping(source = "altaMoto", target = "altaMoto")
    @Mapping(source = "cliente.clienteId", target = "clienteId")
    @Mapping(source = "ordenesDeTrabajo", target = "ordenesDeTrabajo")
    MotocicletaDTO toDTO(Motocicleta motocicleta);

    // Mapea de MotocicletaDTO a Motocicleta
    @Mapping(source = "motocicletaId", target = "motocicletaId")
    @Mapping(source = "patente", target = "dominio")
    @Mapping(source = "marca", target = "marca")
    @Mapping(source = "modelo", target = "modelo")
    @Mapping(source = "cilindrada", target = "cilindrada")
    @Mapping(source = "chasis", target = "chasis")
    @Mapping(source = "kilometraje", target = "kilometraje")
    @Mapping(source = "altaMoto", target = "altaMoto")
    @Mapping(source = "clienteId", target = "cliente.clienteId")
    @Mapping(source = "ordenesDeTrabajo", target = "ordenesDeTrabajo")
    Motocicleta toEntity(MotocicletaDTO motocicletaDTO);

    // Convierte una lista de Motocicletas a una lista de MotocicletaDTOs
    List<MotocicletaDTO> toDTOList(List<Motocicleta> motocicletas);

    // Convierte una lista de MotocicletaDTOs a una lista de Motocicletas
    List<Motocicleta> toEntityList(List<MotocicletaDTO> motocicletaDTOs);
}
