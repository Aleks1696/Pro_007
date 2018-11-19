package com.service.api.request;

public class UpdateStudentRequest extends CreateStudentRequest {

    private Long id;

    public Long getId() {
        return id;
    }
    public UpdateStudentRequest setId(Long id) {
        this.id = id;
        return this;
    }
}
