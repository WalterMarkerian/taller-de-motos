package com.tallerDeMotos.motocicletas.domain.exception;

import com.tallerDeMotos.commons.domain.BaseException;

public class MotocicletaDuplicatePatenteException extends BaseException {
    private static final long serialVersionUID = 1487578649166312037L;
    public static final String DEFAULT_ERROR_CODE = "ERR_DUPLICATE_DOMAIN";

    public MotocicletaDuplicatePatenteException() {
        super(DEFAULT_ERROR_CODE, null);
    }
}