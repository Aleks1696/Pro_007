package com.service.core.domain;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "groupRecords")
public class GroupRecord {

    @Id
    @Column(name = "Group_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "Title")
    private String title;

    @Column(name = "BeginDate")
    private LocalDate beginDate;

    @Column(name = "EndDate")
    private LocalDate endDate;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = CourseRecord.class)
    @JoinColumn(name = "Course_id", referencedColumnName = "Course_id", nullable = false)
    private CourseRecord courseRecord;

    @ManyToMany(mappedBy = "groupRecord", targetEntity = ClientAccount.class)
    private List<ClientAccount> clientAccountList = new ArrayList<>();

    public GroupRecord() {

    }

    public GroupRecord(String title, LocalDate beginDate, LocalDate endDate) {
        this.title = title;
        this.beginDate = beginDate;
        this.endDate = endDate;
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

    public LocalDate getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(LocalDate beginDate) {
        this.beginDate = beginDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public CourseRecord getCourseRecord() {
        return courseRecord;
    }

    public void setCourseRecord(CourseRecord courseRecord) {
        this.courseRecord = courseRecord;
    }

    public List<ClientAccount> getClientAccountList() {
        return clientAccountList;
    }

    public void setClientAccountList(List<ClientAccount> clientAccountList) {
        this.clientAccountList = clientAccountList;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("GroupRecord{");
        sb.append("id=").append(id);
        sb.append(", title='").append(title).append('\'');
        sb.append(", beginDate=").append(beginDate);
        sb.append(", endDate=").append(endDate);
        sb.append(", courseRecord=").append(courseRecord);
        sb.append(", clientAccountList=").append(clientAccountList);
        sb.append('}');
        return sb.toString();
    }
}
