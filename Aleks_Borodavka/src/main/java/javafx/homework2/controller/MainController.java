package javafx.homework2.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.homework2.domain.Contact;
import javafx.homework2.model.ContactModel;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.*;


public class MainController {

    private static Contact activeContact;

    public static Contact getActiveContact() {
        return activeContact;
    }

    @FXML
    private GridPane mainGridPane;

    @FXML
    private ListView<Contact> lstView;

    @FXML
    private TextField fldName;
    @FXML
    private TextField fldSurname;
    @FXML
    private TextField fldPhone;
    @FXML
    private TextField fldEmail;

    private ObservableList<Contact> contactList;

    @FXML
    private void initialize() {
        contactList = FXCollections.observableArrayList(ContactModel.getContacts());
        lstView.setItems(contactList);
    }

    @FXML
    private void activeContact() {
        lstView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                String selectedContact = lstView.getSelectionModel().getSelectedItems().toString();
                for (Contact contact : ContactModel.getContacts()) {
                    if (selectedContact.contains(contact.getName()) &&
                            selectedContact.contains(contact.getSurname())) {
                        activeContact = contact;
                        infoPanelShowDetail();
                    }
                }
            }
        });
    }

    private void infoPanelShowDetail() {
        fldName.setText(activeContact.getName());
        fldSurname.setText(activeContact.getSurname());
        fldPhone.setText(activeContact.getPhone());
        fldEmail.setText(activeContact.getEmail());

    }

    @FXML
    private void addContact() {
        Stage dlgNewContact = new Stage();
        dlgNewContact.setTitle("Add contact");
        dlgNewContact.setResizable(false);
        try {
            dlgNewContact.setScene(new Scene(FXMLLoader.load(
                    getClass().getResource("/javafx/homework2/dialog.fxml")
            )));
        } catch (IOException e) {
            e.printStackTrace();
        }
        dlgNewContact.initOwner(mainGridPane.getScene().getWindow());
        dlgNewContact.initModality(Modality.WINDOW_MODAL);
        dlgNewContact.setOnCloseRequest(event -> {                                                              //lamda
            contactList.setAll(ContactModel.getContacts());
            activeContact();
            clearInfoGridPane();                                                                    //clears info panel
            lstView.refresh();

        });
        dlgNewContact.showAndWait();
    }

    @FXML
    private void editContact() {
        Stage dlgEditContact = new Stage();
        dlgEditContact.setTitle("Contact redactor");
        dlgEditContact.setResizable(false);
        try {
            dlgEditContact.setScene(new Scene(FXMLLoader.load(
                    getClass().getResource("/javafx/homework2/editingDialog.fxml")
            )));
        } catch (IOException e) {
            e.printStackTrace();
        }
        dlgEditContact.initOwner(mainGridPane.getScene().getWindow());
        dlgEditContact.initModality(Modality.WINDOW_MODAL);
        dlgEditContact.setOnCloseRequest(event -> {
            contactList.setAll(ContactModel.getContacts());
            clearInfoGridPane();                                                                    //clears info panel
            activeContact();
            lstView.refresh();
        });
        dlgEditContact.showAndWait();
    }

    @FXML
    private void deleteContact() {
        ContactModel.getContacts().remove(activeContact);
        clearInfoGridPane();
        contactList.setAll(ContactModel.getContacts());
    }

    @FXML
    private void exit() {
        System.exit(0);
    }

    @FXML
    private void openFileOnClick() {
        String path = "/home/dell/Programs/Java Ultimate/Contacts";
        try (BufferedReader fr = new BufferedReader(new FileReader(path))) {
            String contactLine;
            ContactModel.getContacts().clear();
            while ((contactLine = fr.readLine()) != null) {
                String [] parsedText = contactLine.split("\\s*(\\s|,|!|\\.|\\[|])\\s*");
                ContactModel.getContacts().add(new Contact(parsedText[0], parsedText[1], parsedText[2], parsedText[3]));
                contactList.setAll(ContactModel.getContacts());
                lstView.refresh();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    private void saveFileOnClick() {
        String path = "/home/dell/Programs/Java Ultimate/Contacts";
        try (BufferedWriter fout = new BufferedWriter(new FileWriter(path))) {
            for (Contact contact : ContactModel.getContacts()) {
                fout.write(contact.getName() + " ");
                fout.write(contact.getSurname() + ", ");
                fout.write(contact.getPhone() + ", ");
                fout.write(contact.getEmail() + System.lineSeparator());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void clearInfoGridPane() {
        fldName.clear();
        fldSurname.clear();
        fldPhone.clear();
        fldEmail.clear();
    }
}
