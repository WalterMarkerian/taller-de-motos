package com.tallerDeMotos.cliente.application.create;

import com.tallerDeMotos.cliente.domain.dto.ClienteDTO;
import com.tallerDeMotos.cliente.domain.exception.ClienteDuplicateDniException;
import com.tallerDeMotos.cliente.domain.exception.ClienteNotFoundException;
import com.tallerDeMotos.motocicletas.domain.exception.MotocicletaDominioDuplicatedException;

public interface ClienteCreator {
    ClienteDTO createCliente(ClienteDTO clienteDTO) throws ClienteDuplicateDniException, MotocicletaDominioDuplicatedException, ClienteNotFoundException;

}
