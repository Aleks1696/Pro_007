package hibernate.lesson11;

import hibernate.lesson10.util.HibernateUtil;
import hibernate.lesson11.entity.Author;
import hibernate.lesson11.entity.Book;
import org.hibernate.Session;

import java.util.Calendar;

public class Lesson11App {
    public static void main(String[] args) {
        Session session = HibernateUtil.getFactory().openSession();

        Author author1 = new Author("Author 1 Name", "Author 1 Surname");
        Author author2 = new Author("Author 2 Name", "Author 2 Surname");

        session.beginTransaction();
        session.save(author1);
        session.save(author2);
        session.getTransaction().commit();

        Book book1 = new Book("Book1","Descr", Calendar.getInstance().getTime());
        Book book2 = new Book("Book2","Descr", Calendar.getInstance().getTime());
        Book book3 = new Book("Book3","Descr", Calendar.getInstance().getTime());

        session.beginTransaction();
        session.save(book1);
        session.save(book2);
        session.save(book3);
        session.getTransaction().commit();

        HibernateUtil.getFactory().close();
    }
}
