//package com.tallerDeMotos.cliente.application.update_by_dni;
//
//import com.tallerDeMotos.cliente.domain.exception.ClienteNotFoundException;
//import com.tallerDeMotos.cliente.infrastructure.mapper.ClienteMapper;
//import com.tallerDeMotos.cliente.infrastructure.model.dto.ClienteDTO;
//import com.tallerDeMotos.cliente.infrastructure.model.entity.ClienteEntity;
//import com.tallerDeMotos.cliente.infrastructure.repository.ClienteRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//@Service
//public class ClienteUpdateByDniImpl implements ClienteUpdateByDni {
//    @Autowired
//    private ClienteRepository clienteRepository;
//    @Autowired
//    private ClienteMapper clienteMapper;
//
//    @Override
//    public ClienteDTO updateClienteByDni(Long dni, ClienteDTO clienteDTO) throws ClienteNotFoundException {
//        ClienteEntity clienteEntity = clienteRepository.findByDni(dni)
//                .orElseThrow(ClienteNotFoundException::new);
//        clienteMapper.updateEntityFromDTO(clienteDTO, clienteEntity);
//        clienteEntity = clienteRepository.save(clienteEntity);
//        return clienteMapper.toClienteDTO(clienteEntity);
//    }
//}