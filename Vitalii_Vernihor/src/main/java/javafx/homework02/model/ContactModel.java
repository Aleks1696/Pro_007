package javafx.homework02.model;

import javafx.lesson02.domain.Contact;

import java.util.ArrayList;
import java.util.List;

public final class ContactModel {

    private static List<Contact> contacts = new ArrayList<>();

    public static void save(Contact contact) {
        if (contact != null){
            contacts.add(contact);
        }
    }

    public static List<Contact> getContacts(){
        return contacts;
    }
}
