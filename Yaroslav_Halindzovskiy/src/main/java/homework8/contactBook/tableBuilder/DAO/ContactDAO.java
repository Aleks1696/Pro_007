package homework8.contactBook.tableBuilder.DAO;

import homework8.contactBook.domain.Contact;

import java.util.List;

public interface ContactDAO {

    public  void create(Contact contact);
    public List<Contact> findAll ();
}
