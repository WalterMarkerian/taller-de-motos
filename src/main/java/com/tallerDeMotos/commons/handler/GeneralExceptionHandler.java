package com.tallerDeMotos.commons.handler;

import com.tallerDeMotos.cliente.domain.exception.ClienteDuplicateDniException;
import com.tallerDeMotos.cliente.domain.exception.ClienteNotFoundException;
import com.tallerDeMotos.cliente.domain.exception.ClientesNotFoundException;
import com.tallerDeMotos.commons.domain.BaseException;
import com.tallerDeMotos.commons.model.ApiError;
import com.tallerDeMotos.motocicletas.domain.exception.MotocicletaDominioDuplicatedException;
import com.tallerDeMotos.motocicletas.domain.exception.MotocicletasNotFoundException;
import com.tallerDeMotos.ordenDeTrabajo.domain.exception.OrdenDeTrabajoDuplicateIdException;
import com.tallerDeMotos.ordenDeTrabajo.domain.exception.OrdenDeTrabajoNotFoundException;
import com.tallerDeMotos.ordenDeTrabajo.domain.exception.OrdenesDeTrabajoNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;


@Slf4j
@RestControllerAdvice
@RequiredArgsConstructor
public class GeneralExceptionHandler {
//    private final ApiErrorMapper errorMapper;
private final MessageSource messageSource;

    private ApiError buildGeneralResponse(BaseException e, HttpServletRequest request) {
        String exceptionName = e.getClass().getSimpleName();
        String completePath = request.getMethod().concat(":").concat(request.getRequestURI());
        String errorMessage = messageSource.getMessage(e.getCode() + "_MESSAGE", null, e.getMessage(), LocaleContextHolder.getLocale());
        String errorCode = messageSource.getMessage(e.getCode() + "_CODE", null, e.getCode(), LocaleContextHolder.getLocale());
        log.error("Unable to run the requested operation: " + completePath, e);
        return ApiError.builder()
                .timestamp(LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME))
                .error(exceptionName)
                .code(errorCode)
                .message(errorMessage)
                .detailedMessage(e.getMessage())
                .path(completePath)
                .build();
    }
    @ExceptionHandler({ClienteDuplicateDniException.class, MotocicletaDominioDuplicatedException.class,
            OrdenDeTrabajoDuplicateIdException.class})
    public ResponseEntity<Object> handleBadRequestExceptions(BaseException e, HttpServletRequest request) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(buildGeneralResponse(e, request));
    }

    @ExceptionHandler({ClienteNotFoundException.class, ClientesNotFoundException.class,
             MotocicletasNotFoundException.class, OrdenDeTrabajoNotFoundException.class,
            OrdenesDeTrabajoNotFoundException.class})
    public ResponseEntity<Object> handleNotFoundExceptions(BaseException e, HttpServletRequest request) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(buildGeneralResponse(e, request));
    }

    @ExceptionHandler({Exception.class})
    public ResponseEntity<Object> handleGenericException(BaseException e, HttpServletRequest request) {
        BaseException baseException = new BaseException("ERR_UNKNOWN", "Unknown error occurred");
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(buildGeneralResponse(baseException, request));
    }
}