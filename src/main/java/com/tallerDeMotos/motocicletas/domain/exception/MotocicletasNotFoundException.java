package com.tallerDeMotos.motocicletas.domain.exception;

import com.tallerDeMotos.commons.domain.BaseException;

public class MotocicletasNotFoundException extends BaseException {
    private static final long serialVersionUID = 1234567891L;
    public static final String DEFAULT_ERROR_CODE = "ERR_MOTOCICLETAS_NOT_FOUND";

    public MotocicletasNotFoundException() {
        super(DEFAULT_ERROR_CODE, null);
    }
}
