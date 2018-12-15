package com.service.core.domain;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "group")
public class Group {


    @Temporal(TemporalType.DATE)
    private Date beginDate;

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long groupId;

    @Temporal(TemporalType.DATE)
    private Date endDate;

    @Column
    private String title;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Course.class)
    @JoinColumn(name = "course_id", referencedColumnName = "course_id", nullable = false)
    private Course course;

    @ManyToMany(mappedBy = "groups", targetEntity = Account.class)
    private List<Account> accountList = new ArrayList<Account>();

    public Group() {
    }

    public Group(Date beginDate, Date endDate, String title) {
        this.beginDate = beginDate;
        this.endDate = endDate;
        this.title = title;
    }

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public List<Account> getAccountList() {
        return accountList;
    }

    public void setAccountList(List<Account> accountList) {
        this.accountList = accountList;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Group{");
        sb.append("beginDate=").append(beginDate);
        sb.append(", groupId=").append(groupId);
        sb.append(", endDate=").append(endDate);
        sb.append(", title='").append(title).append('\'');
        sb.append(", course=").append(course);
        sb.append(", accountList=").append(accountList);
        sb.append('}');
        return sb.toString();
    }
}


