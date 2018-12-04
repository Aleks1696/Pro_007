package com.service.api.requset;

public class UpdateGroupRequest extends CreateGroupRequest {
    Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
