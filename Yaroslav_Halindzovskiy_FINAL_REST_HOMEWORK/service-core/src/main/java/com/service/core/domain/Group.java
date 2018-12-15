package com.service.core.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "groups")
public class Group {
    @Id
    @Column(name = "group_id")
    @SequenceGenerator(name = "clientId", sequenceName = "seq_client_id")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "clientId")
    private Long id;
    @Column
    private String title;
    @Column
    private Date beginDate;
    @Column
    private Date endDate;
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Course.class)
    @JoinColumn
    private Course course;

    @OneToMany(fetch = FetchType.EAGER,mappedBy = "groups",targetEntity = Account.class)
    private List<Client> clients = new ArrayList<Client>();

    public Group() {
    }

    public Group(String title, Date beginDate, Date endDate, Course course, List<Client> clients) {
        this.title = title;
        this.beginDate = beginDate;
        this.endDate = endDate;
        this.course = course;
        this.clients = clients;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Group{");
        sb.append("id=").append(id);
        sb.append(", title='").append(title).append('\'');
        sb.append(", beginDate=").append(beginDate);
        sb.append(", endDate=").append(endDate);
        sb.append(", course=").append(course);
        sb.append(", clients=").append(clients);
        sb.append('}');
        return sb.toString();
    }
}
