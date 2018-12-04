package com.service.api.requset;

public class UpdateCourseRequest extends CreateCourseRequest {
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
