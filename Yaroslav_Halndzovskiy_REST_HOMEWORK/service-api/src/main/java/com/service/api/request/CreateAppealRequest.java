package com.service.api.request;

import com.service.api.dto.types.StatusAppeal;

public class CreateAppealRequest {


    private String name;
    private String creationDate;
    private String email;
    private String comment;
    private StatusAppeal status;



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public StatusAppeal getStatus() {
        return status;
    }

    public void setStatus(StatusAppeal status) {
        this.status = status;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CreateAppealRequest{");
        sb.append("name='").append(name).append('\'');
        sb.append(", creationDate='").append(creationDate).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append(", comment='").append(comment).append('\'');
        sb.append(", status=").append(status);
        sb.append('}');
        return sb.toString();
    }
}
