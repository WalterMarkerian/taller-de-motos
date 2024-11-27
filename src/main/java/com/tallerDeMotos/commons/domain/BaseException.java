package com.tallerDeMotos.commons.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BaseException extends Exception {
    private static final long serialVersionUID = -2548108658527544758L;
    private final String code;

    public BaseException(String code, String message) {
        super(message);
        this.code = code;
    }

    public BaseException(String code) {
        super(code);  // Si no se pasa el mensaje, usar el código del error como mensaje por defecto
        this.code = code;
    }
}