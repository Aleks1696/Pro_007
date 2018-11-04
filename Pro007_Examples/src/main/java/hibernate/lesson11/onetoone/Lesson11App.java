package hibernate.lesson11.onetoone;



import hibernate.lesson11.onetoone.entity.Author;
import hibernate.lesson11.onetoone.entity.Book;
import hibernate.lesson11.onetoone.util.HibernateUtil;
import hibernate.lesson11.onetoone.util.HibernateUtil;
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

        Book book1 =
                new Book("Book 1", "Book 1 Description", Calendar.getInstance().getTime());
        Book book2 =
                new Book("Book 2", "Book 2 Description", Calendar.getInstance().getTime());
        Book book3 =
                new Book("Book 3", "Book 3 Description", Calendar.getInstance().getTime());

        session.beginTransaction();
        session.save(book1);
        session.save(book2);
        session.save(book3);
        session.getTransaction().commit();

        author1.setBook(book3);
        book3.setAuthor(author1);
        author2.setBook(book1);
        book1.setAuthor(author2);

        session.beginTransaction();
        session.update(book3);
        session.update(author1);
        session.update(book1);
        session.update(author2);
        session.getTransaction().commit();

        session.beginTransaction();
        Author author = session.get(Author.class, 20180001L);
        System.out.println(author);
        System.out.println(author.getBook());

        Book book = session.get(Book.class, 16150002L);
        System.out.println(book);
        System.out.println(book.getAuthor());

        HibernateUtil.getFactory().close();
    }
}
