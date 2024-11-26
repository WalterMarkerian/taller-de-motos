package com.tallerDeMotos.cliente.infrastructure.controller;

import com.tallerDeMotos.cliente.application.create.ClienteCreator;
import com.tallerDeMotos.cliente.domain.dto.ClienteDTO;
import com.tallerDeMotos.cliente.domain.exception.ClienteDuplicateDniException;
import com.tallerDeMotos.cliente.domain.exception.ClienteNotFoundException;
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

    // Inyección por constructor de las dependencias
    public ClienteController(ClienteCreator clienteCreator) {
        this.clienteCreator = clienteCreator;
    }

    // Endpoint para crear un cliente
    @PostMapping
    public ResponseEntity<ClienteDTO> createCliente(@RequestBody ClienteDTO clienteDTO) {
        try {
            ClienteDTO createdCliente = clienteCreator.createCliente(clienteDTO);
            return new ResponseEntity<>(createdCliente, HttpStatus.CREATED);
        } catch (ClienteDuplicateDniException e) {
            return new ResponseEntity<>(HttpStatus.CONFLICT); // 409 Conflict si el DNI ya existe
        } catch (MotocicletaDominioDuplicatedException e) {
            throw new RuntimeException(e);
        } catch (ClienteNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}