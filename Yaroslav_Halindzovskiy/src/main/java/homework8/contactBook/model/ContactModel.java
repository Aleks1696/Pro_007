package homework8.contactBook.model;


import homework8.contactBook.domain.Contact;
import homework8.contactBook.tableBuilder.DAO.ContactDAOimp;
import javafx.scene.control.TextField;
import lesson8.dao.DoctorDAOImp;


import java.util.ArrayList;
import java.util.List;

public final class ContactModel  {

private static List<Contact> contactList = new ArrayList<>();

public static void saveClient (Contact contact){
    if (contact != null) {
        contactList.add(contact);
         new ContactDAOimp().create(contact);
    }


}

    public static boolean takelogin (TextField textField) {

        for (Contact contact : contactList) {
            if (contact.getLogin() == textField.getText()){
                return false;
            }
        }
        return true;
    }



    public static List<Contact> getContactList() {
    contactList = new ContactDAOimp().findAll();

        return contactList;
    }
}
