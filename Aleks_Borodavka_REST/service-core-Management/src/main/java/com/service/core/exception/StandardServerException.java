package com.service.core.exception;

public class StandardServerException extends RuntimeException {

    private final String errorCode;

    public StandardServerException(String errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }

    public String getErrorCode() {
        return errorCode;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("StandardServerException{");
        sb.append("errorCode='").append(errorCode).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
