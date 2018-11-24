package com.service.core.domain;

import com.service.api.dto.types.StatusAppeal;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "appeals")
public class Appeal {
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
    private StatusAppeal status;

    public Appeal() {
    }

    public Appeal(String name, Date creationDate, String email, String comment, StatusAppeal status) {
        this.name = name;
        this.creationDate = creationDate;
        this.email = email;
        this.comment = comment;
        this.status = status;
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
    public StatusAppeal getStatus() {
        return status;
    }
    public void setStatus(StatusAppeal status) {
        this.status = status;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Appeal{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", creationDate=").append(creationDate);
        sb.append(", email='").append(email).append('\'');
        sb.append(", comment='").append(comment).append('\'');
        sb.append(", status=").append(status);
        sb.append('}');
        return sb.toString();
    }
}
