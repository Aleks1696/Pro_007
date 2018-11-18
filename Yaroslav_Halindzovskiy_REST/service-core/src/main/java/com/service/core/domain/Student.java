package com.service.core.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private String name;
    @Column
    private String surname;
    @Column
    private Integer age;
    @Temporal(TemporalType.DATE)
    private Date creation;
    @Temporal(TemporalType.DATE)
    private Date lastUpdate;

    public Student() {
    }

    public Student(String name, String surname, Integer age, Date creation, Date lastUpdate) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.creation = creation;
        this.lastUpdate = lastUpdate;
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
    public Integer getAge() {
        return age;
    }
    public void setAge(Integer age) {
        this.age = age;
    }
    public Date getCreation() {
        return creation;
    }
    public void setCreation(Date creation) {
        this.creation = creation;
    }
    public Date getLastUpdate() {
        return lastUpdate;
    }
    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Student{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", surname='").append(surname).append('\'');
        sb.append(", age=").append(age);
        sb.append(", creation=").append(creation);
        sb.append(", lastUpdate=").append(lastUpdate);
        sb.append('}');
        return sb.toString();
    }
}
