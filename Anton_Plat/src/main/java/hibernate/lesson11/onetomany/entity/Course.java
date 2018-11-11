package hibernate.lesson11.onetomany.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name= "cources")

public class Course {
    @Id
    @Column(name = "course_id")
    @SequenceGenerator(name = "courseId",sequenceName = "seq_course_id",initialValue = 23740000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "courseId")
    private Long id;

    @Column
    private String title;

    @Column
    private String description;
    public Course(){}
    public Course(String title ,String description) {
        this.title = title;
        this.description = description;
    }

    public List<Group> getGroups() {
        return groups;
    }

    public Course setGroups(List<Group> groups) {
        this.groups = groups;
        return this;
    }

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "course", targetEntity = Group.class)
    private List<Group> groups = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public Course setId(Long id) {
        this.id = id;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Course setDescription(String description) {
        this.description = description;
        return this;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Course{");
        sb.append("id=").append(id);
        sb.append(", description='").append(description).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
