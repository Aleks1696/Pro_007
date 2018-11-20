package com.service.api.response;

/* Единый вариант (стандарт) для оформления тела ответа
* code- предназначен для указания кода ошибки
* 200 - OK
* 400 - оишбка в запросе
* 401 - ошибка авторизации
* 403 - Ошибка доступа
* 404- Страница не существует
* 500- Ошибка на стороне сервера
* payload - тело ответа ,которое может изменятся взависимости
* от ситуации */

public class GeneralResponse<T> { // почитайть джинерики
    private String code;
    private T payload;

    public GeneralResponse(){

    }

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
