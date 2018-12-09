package com.service.api.response;

public class GeneralErrorResponse {

    private Long code;
    private String error;
    private String message;

    public GeneralErrorResponse() {

    }

    public GeneralErrorResponse(Long code, String error, String message) {
        this.code = code;
        this.error = error;
        this.message = message;
    }

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("GeneralErrorResponse{");
        sb.append("code=").append(code);
        sb.append(", error='").append(error).append('\'');
        sb.append(", message='").append(message).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
