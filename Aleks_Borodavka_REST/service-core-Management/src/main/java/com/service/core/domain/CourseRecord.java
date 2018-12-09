package com.service.core.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "courseRecords")
public class CourseRecord {

    @Id
    @Column(name = "Course_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "Title")
    private String title;

    @Column(name = "Description")
    private String description;

    @ManyToMany(mappedBy = "courseRecord", targetEntity = ClientRecord.class)
    private List<ClientRecord> clientRecordList = new ArrayList<>();

    //A few Eager fetch type is not allowed in one entity
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "courseRecord", targetEntity = GroupRecord.class)
    private List<GroupRecord> groupRecordList = new ArrayList<>();

    public CourseRecord() {

    }

    public CourseRecord(String title, String description) {
        this.title = title;
        this.description = description;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<ClientRecord> getClientRecordList() {
        return clientRecordList;
    }

    public void setClientRecordList(List<ClientRecord> clientRecordList) {
        this.clientRecordList = clientRecordList;
    }

    public List<GroupRecord> getGroupRecordList() {
        return groupRecordList;
    }

    public void setGroupRecordList(List<GroupRecord> groupRecordList) {
        this.groupRecordList = groupRecordList;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CourseRecord{");
        sb.append("id=").append(id);
        sb.append(", title='").append(title).append('\'');
        sb.append(", description='").append(description).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
