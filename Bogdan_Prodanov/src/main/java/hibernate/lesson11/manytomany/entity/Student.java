package hibernate.lesson11.manytomany.entity;


import hibernate.lesson11.onetomany.entity.Group;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "students")
public class Student {

    @Id
    @Column(name = "student_id")
    @SequenceGenerator(name = "studentId", sequenceName = "seq_student_id", initialValue = 12120000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "studentId")
    private Long id;
    @Column
    private String name;
    @Column
    private String surname;
    @Column
    private Integer age;

    @ManyToMany(fetch = FetchType.EAGER, targetEntity = Group.class)
    @JoinTable(name = "record_on_group", joinColumns = @JoinColumn(name = "student_ref_id", referencedColumnName = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "group_ref_id", referencedColumnName = "group_id"))
    private List<Group> groups = new ArrayList<>();

    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }

    public Student(String name, String surname, Integer age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public Student(){

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

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Student{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", surname='").append(surname).append('\'');
        sb.append(", age=").append(age);
        sb.append('}');
        return sb.toString();
    }
}
