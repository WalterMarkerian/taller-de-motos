package com.tallerDeMotos.cliente.domain.exception;


import com.tallerDeMotos.commons.domain.BaseException;

public class ClientesNotFoundException extends BaseException {
    private static final long serialVersionUID = 1234567890L;
    public static final String DEFAULT_ERROR_CODE = "ERR_CLIENTES_NOT_FOUND";

    public ClientesNotFoundException() {
        super(DEFAULT_ERROR_CODE, null);
    }
}