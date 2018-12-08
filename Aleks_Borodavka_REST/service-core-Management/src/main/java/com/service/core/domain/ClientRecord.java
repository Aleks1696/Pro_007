package com.service.core.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "clientRecords")
public class ClientRecord {

    @Id
    @Column(name = "ClientRecord_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;

    @OneToOne(fetch = FetchType.LAZY, targetEntity = ClientAccount.class)
    @JoinColumn(name = "Account_id", referencedColumnName = "Account_id")
    private ClientAccount account;

    @Column(name = "Name")
    private String name;

    @Column(name = "Surname")
    private String surname;

    @Column(name = "E_mail")
    private String email;

    @Column(name = "Phone_number")
    private String phoneNumber;

    @ManyToMany(fetch = FetchType.EAGER, targetEntity = CourseRecord.class)
    @JoinTable(name = "clients_on_course",
            joinColumns = @JoinColumn(name = "clientRecord_id", referencedColumnName = "ClientRecord_id"),
            inverseJoinColumns = @JoinColumn(name = "courseRecord_id", referencedColumnName = "Course_id"))
    private List<CourseRecord> courseRecord = new ArrayList<>();

    public ClientRecord() {

    }

    public ClientRecord(String name, String surname, String email, String phoneNumber) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ClientAccount getAccount() {
        return account;
    }

    public void setAccount(ClientAccount account) {
        this.account = account;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
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

    public List<CourseRecord> getCourseRecord() {
        return courseRecord;
    }

    public void setCourseRecord(List<CourseRecord> courseRecord) {
        this.courseRecord = courseRecord;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ClientRecord{");
        sb.append("id=").append(id);
        sb.append(", account=").append(account);
        sb.append(", name='").append(name).append('\'');
        sb.append(", surname='").append(surname).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append(", phoneNumber='").append(phoneNumber).append('\'');
        sb.append(", courseRecord=").append(courseRecord);
        sb.append('}');
        return sb.toString();
    }
}
