package javafx.lesoon02.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.lesoon02.domain.Contact;
import javafx.lesoon02.model.ContactModel;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;


public class MainController {

    @FXML
    private VBox mainWindow;

    @FXML
    private ListView<Contact> lstContact;
    private ObservableList<Contact> contacts;

    @FXML
    private void initialize(){
        contacts = FXCollections.observableArrayList(ContactModel.getContacts());
        lstContact.setItems(contacts);
    }

    @FXML
    private void addContactDialog() throws IOException {
        Stage dlgNewContact = new Stage();
        dlgNewContact.setTitle("Add contact");
        dlgNewContact.setResizable(false);

        dlgNewContact.setScene(new Scene(FXMLLoader.load(
                getClass().getResource("/javafx/lesson02/modal/dialog.fxml")
        )));
        dlgNewContact.initOwner(mainWindow.getScene().getWindow());
        dlgNewContact.initModality(Modality.WINDOW_MODAL);
        dlgNewContact.setOnCloseRequest(event -> {          //lamda
            contacts.setAll(ContactModel.getContacts());
            lstContact.refresh();
        });
        dlgNewContact.showAndWait();

    }

    @FXML
    private void closeOnClick(){
        System.exit(0);
    }
}
