package homework2.model;

import homework2.domen.PersonContact;

import java.util.ArrayList;
import java.util.List;

public final class ContactModelBook {


    private static List<PersonContact> contacts = new ArrayList<>();
    public static void save (PersonContact personContact){
        if(contacts!=null){
            contacts.add(personContact);
        }
    }

    public static void delete (PersonContact personContact) {
        contacts.remove(personContact);
    }


    public static void change (int mesto,PersonContact personContact) {
        contacts.set(mesto,personContact);



    }
    public static List<PersonContact> getContacts (){
     return contacts;
    }
}
