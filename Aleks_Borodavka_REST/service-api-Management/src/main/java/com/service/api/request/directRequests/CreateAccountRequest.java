package com.service.api.request.directRequests;

public class CreateAccountRequest {

    private Long clientId;
    private String login;
    private String password;

    public CreateAccountRequest() {
    }

    public CreateAccountRequest(Long clientId, String login, String password) {
        this.clientId = clientId;
        this.login = login;
        this.password = password;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CreateAccountRequest{");
        sb.append("clientId=").append(clientId);
        sb.append(", login='").append(login).append('\'');
        sb.append(", password='").append(password).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
