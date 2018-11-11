package hibernate.lesson11;

import hibernate.lesson11.manytomany.entity.Student;
import hibernate.lesson11.onetomany.entity.Course;
import hibernate.lesson11.onetomany.entity.Group;
import hibernate.lesson11.onetomany.util.HibernateUtil;
import hibernate.lesson11.onetomany.entity.Group;
import hibernate.lesson11.entity.Author;
import hibernate.lesson11.entity.Book;
import org.hibernate.Hibernate;
import org.hibernate.Session;

import java.util.Arrays;
import java.util.Calendar;

public class Lesson11App {
    public static void main(String[] args) {
        Session session = HibernateUtil.getFactory().openSession();


        Course course1 = new Course("Course 1", "Course 1 Description");
        Course course2 = new Course("Course 2", "Course 2 Description");

        session.beginTransaction();
        session.save(course1);
        session.save(course2);
        session.getTransaction().commit();

        Group group1 = new Group("Group 1 - Course 1",
                Calendar.getInstance().getTime(),
                Calendar.getInstance().getTime(),
                course1);

        Group group2 = new Group("Group 2 - Course 1",
                Calendar.getInstance().getTime(),
                Calendar.getInstance().getTime(),
                course1);

        Group group3 = new Group("Group 3 - Course 1",
                Calendar.getInstance().getTime(),
                Calendar.getInstance().getTime(),
                course1);

        Group group4 = new Group("Group 4 - Course 2",
                Calendar.getInstance().getTime(),
                Calendar.getInstance().getTime(),
                course2);

        Group group5 = new Group("Group 5 - Course 2",
                Calendar.getInstance().getTime(),
                Calendar.getInstance().getTime(),
                course2);


        session.beginTransaction();
        session.save(group1);
        session.save(group2);
        session.save(group3);
        session.save(group4);
        session.save(group5);
        session.getTransaction().commit();

        course1.getGroups().addAll(Arrays.asList(group1, group2, group3));
        course2.getGroups().addAll(Arrays.asList(group4, group5));


        session.beginTransaction();
        session.save(course1);
        session.save(course2);
        session.getTransaction().commit();

        Student student1 = new Student("Student 1 Name","Student 1 Surname",20);
        Student student2 = new Student("Student 2 Name","Student 2 Surname",20);
        Student student3 = new Student("Student 3 Name","Student 3 Surname",20);
        Student student4 = new Student("Student 4 Name","Student 4 Surname",20);
        Student student5 = new Student("Student 5 Name","Student 5 Surname",20);

        session.beginTransaction();
        session.save(student1);
        session.save(student2);
        session.save(student3);
        session.save(student4);
        session.save(student5);
        session.getTransaction().commit();

        group1.getStudents().addAll(Arrays.asList(student1,student2,student3));
        group2.getStudents().addAll(Arrays.asList(student1,student2,student4));

        session.beginTransaction();
        session.update(group1);
        session.update(group2);
        session.getTransaction().commit();

        student1.getGroups().addAll(Arrays.asList(group1,group2));
        student2.getGroups().addAll(Arrays.asList(group1,group2));
        student3.getGroups().add(group1);
        student3.getGroups().add(group2);
        student3.getGroups().add(group3);

  session.beginTransaction();
  session.update(student1);
  session.update(student2);
  session.update(student3);
  session.update(student4);
  session.update(student5);
  session.getTransaction().commit();

        HibernateUtil.getFactory().close();
    }
}