package com.tallerDeMotos.ordenDeTrabajo.domain.exception;

import com.tallerDeMotos.commons.domain.BaseException;

public class OrdenesDeTrabajoNotFoundException extends BaseException {
    private static final long serialVersionUID = 1234567891L;
    public static final String DEFAULT_ERROR_CODE = "ERR_WORKORDERS_NOT_FOUND";

    public OrdenesDeTrabajoNotFoundException() {
        super(DEFAULT_ERROR_CODE, null);
    }
}
