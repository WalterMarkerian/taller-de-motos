package com.tallerDeMotos.ordenDeTrabajo.domain.exception;

import com.tallerDeMotos.commons.domain.BaseException;

public class OrdenDeTrabajoDuplicateIdException extends BaseException {
    private static final long serialVersionUID = 1487578649166312037L;
    public static final String DEFAULT_ERROR_CODE = "ERR_DUPLICATE_WORKORDER";

    public OrdenDeTrabajoDuplicateIdException() {
        super(DEFAULT_ERROR_CODE, null);
    }

}
