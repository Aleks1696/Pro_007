package com.domain;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "clients")
public class Client {
    @Id
    @Column(name = "client_id", nullable = false)
    @SequenceGenerator(name = "clientId", sequenceName = "seq_client_id")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "clientId")
    private Long id;
    @Column
    private String name;
    @Column
    private String surname;
    @Column
    private String email;
    @Column
    private String phone;

    @Column
    private Date creationDate;

    @Column
    private Date lastUpdate;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Course.class)
    @JoinColumn
    private Course course;

    @OneToOne(fetch = FetchType.EAGER, targetEntity = Account.class)
    @JoinColumn(name = "account_id", referencedColumnName = "account_id")
    private Account account;

    public Client() {
    }

    public Client(String name, String surname, String email, String phone, Date creationDate, Date lastUpdate, Course course, Account account) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.phone = phone;
        this.creationDate = creationDate;
        this.lastUpdate = lastUpdate;
        this.course = course;
        this.account = account;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Client{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", surname='").append(surname).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append(", phone='").append(phone).append('\'');
        sb.append(", creationDate=").append(creationDate);
        sb.append(", lastUpdate=").append(lastUpdate);
        sb.append(", course=").append(course);
        sb.append(", account=").append(account);
        sb.append('}');
        return sb.toString();
    }
}