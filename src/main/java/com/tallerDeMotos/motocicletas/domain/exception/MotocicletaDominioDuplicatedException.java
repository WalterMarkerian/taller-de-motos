package com.tallerDeMotos.motocicletas.domain.exception;

import com.tallerDeMotos.commons.domain.BaseException;

public class MotocicletaDominioDuplicatedException extends BaseException {
    private static final long serialVersionUID = 1487578649166312037L;
    public static final String DEFAULT_ERROR_CODE = "ERR_DUPLICATE_DOMAIN";

    public MotocicletaDominioDuplicatedException() {
        super(DEFAULT_ERROR_CODE, null);
    }
}