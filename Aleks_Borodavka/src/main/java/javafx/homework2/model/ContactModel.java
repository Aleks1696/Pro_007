package javafx.homework2.model;


import javafx.homework2.domain.Contact;

import java.util.ArrayList;
import java.util.List;

public final class ContactModel {

    private static List<Contact> contacts = new ArrayList<>();

    private static String tempName;
    private static String tempSurname;
    private static String tempPhone;
    private static String tempEmail;

    public static void save(Contact contact) {

        checkFieldsBeforeAdding(contact);                                              //checks if one of the field is Empty

        contacts.add(new Contact(tempName, tempSurname, tempPhone, tempEmail));
    }

    public static void saveAfterAditing(int index, Contact contact){

        checkFieldsBeforeAdding(contact);

        contacts.remove(index);
        contacts.add(index, new Contact(tempName, tempSurname, tempPhone, tempEmail));
    }


    public static List<Contact> getContacts() {
        return contacts;
    }

    private static void checkFieldsBeforeAdding(Contact contact) {
        if (contact != null) {
            if (contact.getName().isEmpty()) {
                tempName = "-";
            } else {
                tempName = contact.getName();
            }

            if (contact.getSurname().isEmpty()) {
                tempSurname = "-";
            } else {
                tempSurname = contact.getSurname();
            }

            if (contact.getPhone().isEmpty()) {
                tempPhone = "-";
            } else {
                tempPhone = contact.getPhone();
            }

            if (contact.getEmail().isEmpty()) {
                tempEmail = "-";
            } else {
                tempEmail = contact.getEmail();
            }
        }
    }
}