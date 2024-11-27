package com.tallerDeMotos.motocicletas.domain.exception;

import com.tallerDeMotos.commons.domain.BaseException;

public class MotocicletaDominioDuplicatedException extends BaseException {
    private static final long serialVersionUID = 1487578649166312037L;
    public static final String DEFAULT_ERROR_CODE = "ERR_DUPLICATE_DOMAIN";
    public static final String DEFAULT_ERROR_MESSAGE = "Dominio repetido desde excepcion";

    public MotocicletaDominioDuplicatedException() {
        super(DEFAULT_ERROR_CODE, DEFAULT_ERROR_MESSAGE);  // Por defecto el mensaje está hardcodeado
    }

    public MotocicletaDominioDuplicatedException(String customMessage) {
        super(DEFAULT_ERROR_CODE, customMessage);  // Puedes pasar un mensaje personalizado
    }
}