package com.tallerDeMotos.cliente.domain.exception;


import com.tallerDeMotos.commons.domain.BaseException;

public class ClienteDuplicateDniException extends BaseException {
    private static final long serialVersionUID = 1487578649166312037L;
    public static final String DEFAULT_ERROR_CODE = "ERR_DUPLICATE_DNI";
    public static final String DEFAULT_ERROR_MESSAGE = "DNI duplicado";

    public ClienteDuplicateDniException() {
        super(DEFAULT_ERROR_CODE, DEFAULT_ERROR_MESSAGE);  // Por defecto el mensaje está hardcodeado
    }

    public ClienteDuplicateDniException(String customMessage) {
        super(DEFAULT_ERROR_CODE, customMessage);  // Puedes pasar un mensaje personalizado
    }

}