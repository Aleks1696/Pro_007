package com.service.api.request;

public class UpdateRequisitionRequest extends CreateRequisitionRequest {
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
