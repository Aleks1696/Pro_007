package javafx.lesson02.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.lesson02.domain.Contact;
import javafx.lesson02.model.ContactModel;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Observable;


public class MainController {

    @FXML
    private VBox mainWindow;

    @FXML
    private ListView<Contact> lstContacts;
    private ObservableList<Contact> contacts;

    @FXML
    private void initialize(){
        contacts = FXCollections.observableArrayList(ContactModel.getContacts());
        lstContacts.setItems(contacts);
    }

    @FXML
    private void addContactDialog() throws IOException {
        Stage dlgNewContact = new Stage();
        dlgNewContact.setTitle("Добавление контакта");
        dlgNewContact.setResizable(false);
        GridPane dlgView = FXMLLoader.load(
                getClass().getResource("/javafx/lesson02/modal/dialog.fxml")
        );
        dlgNewContact.setScene(new Scene(dlgView));
        dlgNewContact.initOwner(mainWindow.getScene().getWindow());
        dlgNewContact.initModality(Modality.WINDOW_MODAL);
        dlgNewContact.setOnCloseRequest(event -> {
            contacts.setAll(ContactModel.getContacts());
            lstContacts.refresh();
        });
        dlgNewContact.showAndWait();
    }

    @FXML
    private void closeOnClick(){
        System.exit(0);
    }

}
