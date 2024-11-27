package com.tallerDeMotos.cliente.infrastructure.controller;

import com.tallerDeMotos.cliente.application.create.ClienteCreator;
import com.tallerDeMotos.cliente.domain.dto.ClienteDTO;
import com.tallerDeMotos.cliente.domain.exception.ClienteDuplicateDniException;
import com.tallerDeMotos.cliente.domain.exception.ClienteNotFoundException;
import com.tallerDeMotos.cliente.infrastructure.repository.ClienteRepository;
import com.tallerDeMotos.motocicletas.domain.exception.MotocicletaDominioDuplicatedException;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteCreator clienteCreator;
    private final ClienteRepository clienteRepository;

    // Inyección por constructor de las dependencias
    public ClienteController(ClienteCreator clienteCreator, ClienteRepository clienteRepository) {
        this.clienteCreator = clienteCreator;
        this.clienteRepository = clienteRepository;
    }

    // Endpoint para crear un cliente
    @PostMapping
    public ResponseEntity<ClienteDTO> createCliente(@Valid @RequestBody ClienteDTO clienteDTO) throws ClienteNotFoundException, ClienteDuplicateDniException, MotocicletaDominioDuplicatedException {
        // Validación para evitar duplicados
        if(clienteRepository.existsByDni(clienteDTO.getDni())) {
            throw new ClienteDuplicateDniException();
        }
        ClienteDTO createdCliente = clienteCreator.createCliente(clienteDTO);
            return new ResponseEntity<>(createdCliente, HttpStatus.CREATED);

    }
}