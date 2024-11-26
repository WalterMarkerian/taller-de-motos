package com.tallerDeMotos.cliente.domain.exception;


import com.tallerDeMotos.commons.domain.BaseException;

public class ClienteDuplicateDniException extends BaseException {
    private static final long serialVersionUID = 1487578649166312037L;
    public static final String DEFAULT_ERROR_CODE = "ERR_DUPLICATE_DNI";

    public ClienteDuplicateDniException() {
        super(DEFAULT_ERROR_CODE, null);
    }
}