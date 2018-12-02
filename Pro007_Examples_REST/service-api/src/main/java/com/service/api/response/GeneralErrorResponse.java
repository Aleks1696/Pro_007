package com.service.api.response;

public class GeneralErrorResponse {

    private Long code;
    private String error;
    private String message;

    public GeneralErrorResponse(Long code, String error, String message) {
        this.code = code;
        this.error = error;
        this.message = message;
    }

    public Long getCode() {
        return code;
    }
    public String getError() {
        return error;
    }
    public String getMessage() {
        return message;
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
