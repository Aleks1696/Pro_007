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
    @SequenceGenerator(name="groupId", sequenceName = "seq_group_id",initialValue = 21340000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "groupId")
    private Long id;

    @Column
    private String title;

    @Temporal(TemporalType.DATE)
    private Date beginDate;

    @Temporal(TemporalType.DATE)
    private Date endDate;

    public List<Student> getStudents() {
        return students;
    }

    public Group setStudents(List<Student> students) {
        this.students = students;
        return this;
    }

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Course.class)
    @JoinColumn(name = "course_id", referencedColumnName = "course_id", nullable = false)
    private Course course;


    @ManyToMany(mappedBy = "groups", targetEntity = Student.class)
    private List<Student> students = new ArrayList<>();

    public Course getCourse() {
        return course;
    }

    public Group setCourse(Course course) {
        this.course = course;
        return this;
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

    public Group setId(Long id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public Group setTitle(String title) {
        this.title = title;
        return this;
    }

    public Date getBeginDate() {
        return beginDate;
    }

    public Group setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
        return this;
    }

    public Date getEndDate() {
        return endDate;
    }

    public Group setEndDate(Date endDate) {
        this.endDate = endDate;
        return this;
    }

    public Group() {
    }
}
