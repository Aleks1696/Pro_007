package com.service.api.response;

/*Единый вариант (стандарт) для оформления тела ответа
*
* code - предназначен для указания кода ошибки
*        200 - ОК
*        400 - Ошибка в запросе
*        401 - Ошибка авторизаций
*        403 - Ошибка доступа
*        404 - Страница не существует
*        500 - Ошибка на стороне сервера
* payload - тело ответа которое может менятся в зависимости от ситуации*/
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
