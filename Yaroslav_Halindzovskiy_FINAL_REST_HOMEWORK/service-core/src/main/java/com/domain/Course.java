package com.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Entity
@Table(name = "courses")
public class Course {
    @Id
    @Column(name = "course_id", nullable = false)
    @SequenceGenerator(name = "courseId", sequenceName = "seq_course_id")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "courseId")
    private Long id	;
    @Column
    private String description;
    @Column
    private String	title;
    @Column
    private Date creationDate;
    @Column
    private Date lastUpdate;
    @OneToMany(fetch = FetchType.EAGER,mappedBy = "courses",targetEntity = Client.class)
    private List<Client> clients = new ArrayList<Client>();
    @OneToMany(fetch = FetchType.EAGER,mappedBy = "courses", targetEntity = Group.class)
    private List<Group> groups = new ArrayList<Group>();

    public Course(String description, String title, Date creationDate, Date lastUpdate, List<Client> clients, List<Group> groups) {
        this.description = description;
        this.title = title;
        this.creationDate = creationDate;
        this.lastUpdate = lastUpdate;
        this.clients = clients;
        this.groups = groups;
    }

    public Course() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Course{");
        sb.append("id=").append(id);
        sb.append(", description='").append(description).append('\'');
        sb.append(", title='").append(title).append('\'');
        sb.append(", creationDate=").append(creationDate);
        sb.append(", lastUpdate=").append(lastUpdate);
        sb.append(", clients=").append(clients);
        sb.append(", groups=").append(groups);
        sb.append('}');
        return sb.toString();
    }
}
