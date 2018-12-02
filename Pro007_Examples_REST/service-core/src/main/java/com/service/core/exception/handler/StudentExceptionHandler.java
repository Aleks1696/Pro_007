package com.service.core.exception.handler;

import com.service.api.response.GeneralErrorResponse;
import com.service.core.exception.StudentDataException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.util.WebUtils;

@ControllerAdvice
public class StudentExceptionHandler {

    @ExceptionHandler(value = StudentDataException.class)
    protected ResponseEntity<Object> handleStudentException(
            StudentDataException exc, WebRequest request) {
        return handleException(exc,
                new GeneralErrorResponse(
                        500L, exc.getErrorCode(), exc.getMessage()), request);
    }

    private ResponseEntity<Object> handleException(
            Exception exc, Object body, WebRequest request) {
        request.setAttribute(WebUtils.ERROR_EXCEPTION_ATTRIBUTE, exc, WebRequest.SCOPE_REQUEST);
        return new ResponseEntity<Object>(body, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
