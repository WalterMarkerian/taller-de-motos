package com.tallerDeMotos.commons.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ApiError {

    String timestamp;
    String error;
    String code;
    String message;
    String detailedMessage;
    String path;
}
