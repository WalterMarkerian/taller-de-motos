//package com.tallerDeMotos.cliente.application.delete_by_dni;
//
//import com.tallerDeMotos.cliente.domain.entity.Cliente;
//import com.tallerDeMotos.cliente.domain.exception.ClienteNotFoundException;
//import com.tallerDeMotos.cliente.infrastructure.repository.ClienteRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.Optional;
//
//@Service
//public class ClienteDeleterByDniImpl implements ClienteDeleterByDni {
//    @Autowired
//    private ClienteRepository clienteRepository;
//
//    @Override
//    public void deleteClienteByDni(Long dni) throws ClienteNotFoundException {
//        Optional<Cliente> clienteOptional = clienteRepository.findByDni(dni);
//        if (clienteOptional.isPresent()) {
//            clienteRepository.delete(clienteOptional.get());
//        } else {
//            throw new ClienteNotFoundException();
//        }
//    }
//}
