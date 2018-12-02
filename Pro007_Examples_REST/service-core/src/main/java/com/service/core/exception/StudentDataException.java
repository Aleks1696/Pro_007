package com.service.core.exception;

public class StudentDataException extends RuntimeException{

    private final String errorCode;

    public StudentDataException(String errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }

    public String getErrorCode() {
        return errorCode;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("StudentDataException{");
        sb.append("errorCode='").append(errorCode).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
