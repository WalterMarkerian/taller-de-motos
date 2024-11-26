package com.tallerDeMotos.ordenDeTrabajo.domain.exception;

import com.tallerDeMotos.commons.domain.BaseException;

public class OrdenDeTrabajoNotFoundException extends BaseException {
    private static final long serialVersionUID = 1234567891L;
    public static final String DEFAULT_ERROR_CODE = "ERR_WORKORDER_NOT_FOUND";

    public OrdenDeTrabajoNotFoundException() {
        super(DEFAULT_ERROR_CODE, null);
    }
}
