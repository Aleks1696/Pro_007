package hibernate.lesson11.onetomane;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "courses")
public class Course {


    @Id
@Column(name = "course_id")
@SequenceGenerator ( name = "courseId", sequenceName = "seq_course_id", initialValue = 2374000)
@GeneratedValue (strategy = GenerationType.SEQUENCE,generator = "courseId")
private Long id;

    @Column
private String title;

    @Column
private String description;

    @Column
    @OneToMany(fetch = FetchType.EAGER,mappedBy = "course",targetEntity = Group.class)
    private List<Group> groups = new ArrayList<>();

    public Course(String title, String description) {
        this.title = title;
        this.description = description;
    }

    Course() {
    }

    public Long getId() {
        return id;
    }

    public Course setId(Long id) {
        this.id = id;
        return this;
    }

    public List<Group> getGroups() {
        return groups;
    }
    public Course setGroups(List<Group> groups) {
        this.groups = groups;
        return this;
    }
    public String getTitle() {
        return title;
    }
    public Course setTitle(String title) {
        this.title = title;
        return this;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Course{");
        sb.append("id=").append(id);
        sb.append(", title='").append(title).append('\'');
        sb.append(", description='").append(description).append('\'');
        sb.append('}');
        return sb.toString();
    }

    public String getDescription() {
        return description;
    }

    public Course setDescription(String description) {
        this.description = description;
        return this;
    }
}