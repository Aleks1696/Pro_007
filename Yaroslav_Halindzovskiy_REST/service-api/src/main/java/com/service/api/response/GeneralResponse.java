package com.service.api.response;
/*Code - предназначен для передачи кода ошибки
* 200  - Ok
* 400 - ошибка в запросе
* 401 - ошибка авторизации
* 403 - ошибка в полномочиях
* 404 - Станица не существует
* 500 - Ошибка на стороне сервера
* payload - тело ответа которое может меняться в взависимости от ситуации
* */
public class GeneralResponse<T> {
    private String code;
    private T payload;

    public GeneralResponse(String code, T payload) {
        this.code = code;
        this.payload = payload;
    }

    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public T getPayload() {
        return payload;
    }
    public void setPayload(T payload) {
        this.payload = payload;
    }
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("GeneralResponse{");
        sb.append("code='").append(code).append('\'');
        sb.append(", payload=").append(payload);
        sb.append('}');
        return sb.toString();
    }



}
