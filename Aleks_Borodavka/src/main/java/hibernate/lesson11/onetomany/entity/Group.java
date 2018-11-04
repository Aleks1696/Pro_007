package hibernate.lesson11.onetomany.entity;

import hibernate.lesson11.manytomany.entity.Student;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "groups")
public class Group {

    @Id
    @Column(name = "group_id")
    @SequenceGenerator(name = "groupId", sequenceName = "seq_group_id", initialValue = 21340000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "groupId")
    private Long id;

    @Column
    private String title;

    @Temporal(TemporalType.DATE)
    private Date beginDate;

    @Temporal(TemporalType.DATE)
    private Date endDate;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Course.class)
    @JoinColumn(name = "course_id", referencedColumnName = "course_id", nullable = false)
    private Course course;

    @ManyToMany(mappedBy = "groups", targetEntity = Student.class)
    private List<Student> students = new ArrayList<>();

    public Group() {
    }

    public Group(String title, Date beginDate, Date endDate, Course course) {
        this.title = title;
        this.beginDate = beginDate;
        this.endDate = endDate;
        this.course = course;
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

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Group{");
        sb.append("id=").append(id);
        sb.append(", title='").append(title).append('\'');
        sb.append(", beginDate=").append(beginDate);
        sb.append(", endDate=").append(endDate);
        sb.append('}');
        return sb.toString();
    }
}
