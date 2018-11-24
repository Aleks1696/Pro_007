package com.service.api.dto;


/*
 * Data Transfer Object - основное назначение класса
 * передача параметров для Frontend*/

import com.service.api.request.StatusRequisitionRequest;

public class RequisitionDTO {
    private String comment;
    private String creationDate;
    private String email;
    private Long id;
    private String name;
    private String phone;
    private StatusRequisitionRequest status;

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public StatusRequisitionRequest getStatus() {
        return status;
    }

    public void setStatus(StatusRequisitionRequest status) {
        this.status = status;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("RequisitionDTO{");
        sb.append("comment='").append(comment).append('\'');
        sb.append(", creationDate='").append(creationDate).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append(", id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", phone='").append(phone).append('\'');
        sb.append(", status=").append(status);
        sb.append('}');
        return sb.toString();
    }
}

