package com.service.api.response;


public class GeneralResponse<T> {

    private Long code;
    private T playload;

    public GeneralResponse() {

    }

    public GeneralResponse(Long code, T playload) {
        this.code = code;
        this.playload = playload;
    }

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public T getPlayload() {
        return playload;
    }

    public void setPlayload(T playload) {
        this.playload = playload;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("GeneralResponse{");
        sb.append("code=").append(code);
        sb.append(", playload=").append(playload);
        sb.append('}');
        return sb.toString();
    }
}
