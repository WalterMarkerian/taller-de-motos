package com.tallerDeMotos.cliente.infrastructure.mapper;

import com.tallerDeMotos.cliente.domain.dto.ClienteDTO;
import com.tallerDeMotos.cliente.domain.entity.Cliente;
import com.tallerDeMotos.motocicletas.infrastructure.mapper.MotocicletaMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring", uses = MotocicletaMapper.class)
public interface ClienteMapper {

    ClienteMapper INSTANCE = Mappers.getMapper(ClienteMapper.class);

    // Mapea de Cliente a ClienteDTO
    @Mapping(source = "clienteId", target = "clienteId")
    @Mapping(source = "dni", target = "dni")
    @Mapping(source = "fechaNacimiento", target = "fechaNacimiento")
    @Mapping(source = "altaCliente", target = "altaCliente")
    @Mapping(source = "nombre", target = "nombre")
    @Mapping(source = "apellido", target = "apellido")
    @Mapping(source = "genero", target = "genero")
    @Mapping(source = "telefono", target = "telefono")
    @Mapping(source = "domicilio", target = "domicilio")
    @Mapping(source = "motocicletas", target = "motocicletas")
    ClienteDTO toDTO(Cliente cliente);

    // Mapea de ClienteDTO a Cliente
    @Mapping(source = "clienteId", target = "clienteId")
    @Mapping(source = "dni", target = "dni")
    @Mapping(source = "fechaNacimiento", target = "fechaNacimiento")
    @Mapping(source = "altaCliente", target = "altaCliente")
    @Mapping(source = "nombre", target = "nombre")
    @Mapping(source = "apellido", target = "apellido")
    @Mapping(source = "genero", target = "genero")
    @Mapping(source = "telefono", target = "telefono")
    @Mapping(source = "domicilio", target = "domicilio")
    @Mapping(source = "motocicletas", target = "motocicletas")
    Cliente toEntity(ClienteDTO clienteDTO);

    // Convierte una lista de Clientes a una lista de ClienteDTOs
    List<ClienteDTO> toDTOList(List<Cliente> clientes);

    // Convierte una lista de ClienteDTOs a una lista de Clientes
    List<Cliente> toEntityList(List<ClienteDTO> clienteDTOs);
}