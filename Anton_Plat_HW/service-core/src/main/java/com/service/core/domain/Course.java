package com.service.core.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "course")
public class Course {

    @Id
    @Column()
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long courceId;

    @Column
   private String description;

    @Column
    private String 	string;





    @OneToMany(fetch = FetchType.EAGER,mappedBy = "course",targetEntity = Group.class)
    private List<Group> groupList = new ArrayList<Group>();


    public Course(String description, String string) {
        this.description = description;
        this.string = string;
    }

    public Course() {

    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Course{");
        sb.append("description='").append(description).append('\'');
        sb.append(", string='").append(string).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
