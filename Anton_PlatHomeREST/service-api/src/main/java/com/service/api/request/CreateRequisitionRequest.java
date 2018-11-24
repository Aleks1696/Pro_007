package com.service.api.request;

public class CreateRequisitionRequest {
    private String name;
    private String creationDate;
    private String email;
    private String comment;
    private StatusRequisitionRequest status;
    private String phone;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

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

    public StatusRequisitionRequest getStatus() {
        return status;
    }

    public void setStatus(StatusRequisitionRequest status) {
        this.status = status;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CreateRequisitionRequest{");
        sb.append("name='").append(name).append('\'');
        sb.append(", creationDate='").append(creationDate).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append(", comment='").append(comment).append('\'');
        sb.append(", status=").append(status);
        sb.append(", phone='").append(phone).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
