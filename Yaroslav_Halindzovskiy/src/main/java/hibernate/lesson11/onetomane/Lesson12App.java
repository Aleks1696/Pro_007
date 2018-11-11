package hibernate.lesson11.onetomane;

import hibernate.lesson11.manytomany.Student;
import hibernate.lesson11.onetomane.util.HibernateUtil;
import org.hibernate.Session;


import java.util.Arrays;
import java.util.Calendar;

public class Lesson12App {

    public static void main(String[] args) {
        Session session = HibernateUtil.getFactory().openSession();
        Course course1 =
                new Course("Corse 1", "Course 1 Description");
        Course course2 =
                new Course("Course 2", "Course 2 Description");
        session.beginTransaction();
        session.save(course1);
        session.save(course2);
        session.getTransaction().commit();

        Group group1 = new Group("Grop 1 - Course 1", Calendar.getInstance().getTime(),Calendar.getInstance().getTime(),course1);
        Group group2= new Group("Grop 2 - Course 1", Calendar.getInstance().getTime(),Calendar.getInstance().getTime(),course1);
        Group group3 = new Group("Grop 3 - Course 1", Calendar.getInstance().getTime(),Calendar.getInstance().getTime(),course1);
        Group group4 = new Group("Grop 4 - Course 2", Calendar.getInstance().getTime(),Calendar.getInstance().getTime(),course2);
        Group group5 = new Group("Grop 5 - Course 2", Calendar.getInstance().getTime(),Calendar.getInstance().getTime(),course2);

        session.beginTransaction();
        session.save(group1);
        session.save(group2);
        session.save(group3);
        session.save(group4);
        session.save(group5);
        session.getTransaction().commit();
        session.beginTransaction();
        course1.getGroups().addAll(Arrays.asList(group1,group2,group3));
        course2.getGroups().addAll(Arrays.asList(group4,group5));
        session.getTransaction().commit();
        HibernateUtil.getFactory().close();

        Student student1 = new Student("Student 1 name","Student 1 Surname",20);
        Student student2 = new Student("Student 2 name","Student 2 Surname",20);
        Student student3 = new Student("Student 3 name","Student 3 Surname",20);
        Student student4 = new Student("Student 4 name","Student 4 Surname",20);
        Student student5 = new Student("Student 5 name","Student 5 Surname",20);

        session.beginTransaction();
        session.save(student1);
        session.save(student2);
        session.save(student3);
        session.save(student4);
        session.save(student5);
       session.getTransaction().commit();
       HibernateUtil.getFactory().close();

       group1.getStudents().addAll(Arrays.asList(student1,student2,student3));
       group2.getStudents().addAll(Arrays.asList(student1,student2,student3,student4,student5));
       session.beginTransaction();
       session.update(group1);
       session.update(group2);
       session.getTransaction().commit();

       student1.getGroups().addAll(Arrays.asList(group1,group2));
       student2.getGroups().addAll(Arrays.asList(group1,group2));
       student3.getGroups().add(group1);
       student4.getGroups().add(group2);
       student5.getGroups().add(group2);

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
