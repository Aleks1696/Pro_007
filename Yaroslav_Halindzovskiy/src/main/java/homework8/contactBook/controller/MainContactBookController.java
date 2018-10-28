package homework8.contactBook.controller;

import homework8.contactBook.domain.Contact;
import homework8.contactBook.model.ContactModel;
import homework8.contactBook.tableBuilder.DAO.ContactDAOimp;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;
import java.util.Observable;

public class MainContactBookController {
    @FXML
    private ListView<Contact> lstView;
    private ObservableList<Contact> contacts;


    @FXML
    private TextField fldLogin;
    @FXML
    private TextField fldPass;


    @FXML
    private void initialize() {
        contacts = FXCollections.observableArrayList(ContactModel.getContactList());
     //   lstView.setItems(contacts);
    }


    @FXML
    public void registation() throws IOException {
        Stage dlgRegistarion = new Stage();
        dlgRegistarion.setTitle("Регистрация");
        dlgRegistarion.setResizable(false);
        dlgRegistarion.setScene(new Scene(FXMLLoader.load(getClass().getResource("/homework8/loginRegistration.fxml"))));
//        dlgRegistarion.initOwner(mainWindow.getScene().getWindow());
//        dlgRegistarion.initModality(Modality.WINDOW_MODAL);
        dlgRegistarion.showAndWait();

    }

    @FXML
    public void login() {

        for (Contact contact : contacts) {
            if (fldLogin.getText().equals(contact.getLogin())) {
                if (fldPass.getText().equals(contact.getPassword())) {
                    lstView.setItems(contacts);

break;
                }

            }


        }

    }
}


