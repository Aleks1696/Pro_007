package com.service.api.request;

public class UpdateAppealRequest extends CreateAppealRequest {
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
