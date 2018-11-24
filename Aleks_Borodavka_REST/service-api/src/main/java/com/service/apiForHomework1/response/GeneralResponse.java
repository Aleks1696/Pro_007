package com.service.apiForHomework1.response;

public class GeneralResponse<T> {

    private String code;
    private T playload;

    public GeneralResponse() {
    }

    public GeneralResponse(String code, T playload) {
        this.code = code;
        this.playload = playload;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
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
        sb.append("code='").append(code).append('\'');

        if (playload != null) {
            sb.append(", playload=").append(playload);
        }
        sb.append('}');
        return sb.toString();
    }
}
