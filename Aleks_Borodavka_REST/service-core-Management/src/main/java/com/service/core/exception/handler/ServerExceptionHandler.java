package com.service.core.exception.handler;

import com.service.api.response.GeneralErrorResponse;
import com.service.core.exception.StandardServerException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.util.WebUtils;

@ControllerAdvice
public class ServerExceptionHandler {

    @ExceptionHandler(value = StandardServerException.class)
    private ResponseEntity<Object> handleServerException(StandardServerException exception,
                                                         WebRequest request) {
        return handleException(exception, new GeneralErrorResponse(500L, exception.getErrorCode(),
                exception.getMessage()), request);
    }

    private ResponseEntity<Object> handleException(Exception exception, Object object,
                                                   WebRequest request) {
        request.setAttribute(WebUtils.ERROR_EXCEPTION_ATTRIBUTE, exception, WebRequest.SCOPE_REQUEST);
        return new ResponseEntity<Object>(object, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }


}
