package com.service.core.domain;


import com.service.api.request.StatusRequisitionRequest;
import javax.persistence.*;
import java.util.Date;
@Entity
@Table(name = "requisitions")

public class Requisition {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String name;

    @Temporal(TemporalType.DATE)
    private Date creationDate;

    @Column
    private String email;

    @Column
    private String comment;

    @Column
    private StatusRequisitionRequest statusRequisitionRequest;
    @Column
    private String phone;

    public Requisition() {
    }


    public Requisition(String name, Date creationDate, String email, String comment, StatusRequisitionRequest statusRequisitionRequest, String phone) {
        this.name = name;
        this.creationDate = creationDate;
        this.email = email;
        this.comment = comment;
        this.statusRequisitionRequest = statusRequisitionRequest;
        this.phone = phone;
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

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
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

    public StatusRequisitionRequest getStatusRequisitionRequest() {
        return statusRequisitionRequest;
    }

    public void setStatusRequisitionRequest(StatusRequisitionRequest statusRequisitionRequest) {
        this.statusRequisitionRequest = statusRequisitionRequest;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

}
