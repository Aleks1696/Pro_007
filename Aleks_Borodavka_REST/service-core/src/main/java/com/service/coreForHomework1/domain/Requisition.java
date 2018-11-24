package com.service.coreForHomework1.domain;

import com.service.apiForHomework1.dto.RequisitionDTO;
import com.service.apiForHomework1.types.RequisitionStatus;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "requisitions")
public class Requisition extends RequisitionDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "Name")
    private String name;

    @Column(name = "Email")
    private String email;

    @Column(name = "Phone_Number")
    private String phoneNumber;

    @Column(name = "Comment")
    private String comment;

    @Column(name = "Status")
    @Enumerated(EnumType.STRING)
    private RequisitionStatus status;

    @Column(name = "Creation_Date")
    @Temporal(TemporalType.DATE)
    private Date creationDate;

    public Requisition() {
    }

    public Requisition(String name, String email, String phoneNumber, String comment,
                       RequisitionStatus status, Date creationDate) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.comment = comment;
        this.status = status;
        this.creationDate = creationDate;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public RequisitionStatus getStatus() {
        return status;
    }

    public void setStatus(RequisitionStatus status) {
        this.status = status;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Requisition{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append(", phoneNumber='").append(phoneNumber).append('\'');
        sb.append(", comment='").append(comment).append('\'');
        sb.append(", status='").append(status).append('\'');
        sb.append(", creationDate=").append(creationDate);
        sb.append('}');
        return sb.toString();
    }
}
