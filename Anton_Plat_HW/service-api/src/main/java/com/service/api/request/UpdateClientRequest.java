package com.service.api.request;

public class UpdateClientRequest extends CreateClientRequest {
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
