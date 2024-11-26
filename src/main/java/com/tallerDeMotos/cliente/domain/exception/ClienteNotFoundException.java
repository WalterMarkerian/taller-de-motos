package com.tallerDeMotos.cliente.domain.exception;


import com.tallerDeMotos.commons.domain.BaseException;

public class ClienteNotFoundException extends BaseException {
    private static final long serialVersionUID = 8237342515687888090L;
    public static final String DEFAULT_ERROR_CODE = "ERR_CLIENT_NOT_FOUND";

    public ClienteNotFoundException() {
        super(DEFAULT_ERROR_CODE, null);
    }
}