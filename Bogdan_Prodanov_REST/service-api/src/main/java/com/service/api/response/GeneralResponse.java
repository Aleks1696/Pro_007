package com.service.api.response;


/* Единый вариант - (стандарт) для оформления тела ответа
*
* code - предназначен для указания кода ошибки
*        200 - ОК
*        400 - Ошибка в запросе
*        401 - Ошибка авторизации
*        403 - Ошибка в полномочиях
*        404 - Страница не существует
*        500 - Ошибка на стороне сервера
* payload - тело ответа которое может меняться в зависимости от ситуации*/
public class GeneralResponse<T> {

    private String code;
    private T payload;

    public GeneralResponse(){}

    public GeneralResponse(String code, T payload) {
        this.code = code;
        this.payload = payload;
    }

    public String getCode() {
        return code;
    }
    public GeneralResponse<T> setCode(String code) {
        this.code = code;
        return this;
    }
    public T getPayload() {
        return payload;
    }
    public GeneralResponse<T> setPayload(T payload) {
        this.payload = payload;
        return this;
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
