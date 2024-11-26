package com.tallerDeMotos.motocicletas.domain.exception;

import com.tallerDeMotos.commons.domain.BaseException;

public class MotocicletaDominioNotFoundException extends BaseException {
    private static final long serialVersionUID = 8237342515687888090L;
    public static final String DEFAULT_ERROR_CODE = "ERR_DOMAIN_NOT_FOUND";

    public MotocicletaDominioNotFoundException() {
        super(DEFAULT_ERROR_CODE, null);
    }
}