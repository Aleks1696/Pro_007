package hibernate.lesson11.manytomany;

import hibernate.lesson11.onetomane.Group;

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
    @JoinTable(name = "record_on_group",
            joinColumns = @JoinColumn(name = "student_ref_id",
                    referencedColumnName = "student_id"),

            inverseJoinColumns = @JoinColumn(name = "group_ref_id",
                    referencedColumnName = "group_id"))
    private List<Group> groups = new ArrayList<>();

    public Student() {

    }

    public Student(String name, String surname, Integer age, List<Group> groups) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.groups = groups;
    }

    public List<Group> getGroups() {
        return groups;
    }

    public Student setGroups(List<Group> groups) {
        this.groups = groups;
        return this;
    }

    public Long getId() {
        return id;
    }

    public Student setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Student setName(String name) {
        this.name = name;
        return this;
    }

    public String getSurname() {
        return surname;
    }

    public Student setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public Integer getAge() {
        return age;
    }

    public Student setAge(Integer age) {
        this.age = age;
        return this;
    }

    public Student(String name, String surname, Integer age) {
        this.name = name;
        this.surname = surname;
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
