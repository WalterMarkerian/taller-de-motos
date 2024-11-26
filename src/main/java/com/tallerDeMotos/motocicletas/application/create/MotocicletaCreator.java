package com.tallerDeMotos.motocicletas.application.create;

import com.tallerDeMotos.cliente.domain.exception.ClienteNotFoundException;
import com.tallerDeMotos.motocicletas.domain.dto.MotocicletaDTO;
import com.tallerDeMotos.motocicletas.domain.exception.MotocicletaDominioDuplicatedException;

public interface MotocicletaCreator {
    MotocicletaDTO createMoto(MotocicletaDTO motocicletaDTO) throws MotocicletaDominioDuplicatedException, ClienteNotFoundException;
}
