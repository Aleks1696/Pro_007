package homework2.controller;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import homework2.domen.PersonContact;
import homework2.model.ContactModelBook;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.MultipleSelectionModel;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class MainControllerBook {

    @FXML
    private AnchorPane mainWindow;
    @FXML
    private GridPane grWindow;
    @FXML
    private Text txtName;
    @FXML
    private Text txtSurname;
    @FXML
    private Text txtNumber;
    @FXML
    private Text txtEmail;
    @FXML
    private Button btnDelete;


    @FXML
    private ListView<PersonContact> lstContacts;
    private ObservableList<PersonContact> contacts;

    public static int mesto;

    @FXML
    private void initialize() {
        contacts = FXCollections.observableArrayList(ContactModelBook.getContacts());
        lstContacts.setItems(contacts);
        btnDelete.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                deleteContacte();
                btnDelete.cancelButtonProperty();
                btnDelete.isCancelButton();

            }
        });

    }

    @FXML
    private void addContactToDialog() throws IOException {
        Stage dlnNewPersinContact = new Stage();
        dlnNewPersinContact.setTitle("Добавление контактов");
        dlnNewPersinContact.setResizable(false);
        dlnNewPersinContact.setScene(new Scene(FXMLLoader.load(getClass().getResource("/homework2/modal/dialog.fxml"))));
        dlnNewPersinContact.initOwner(mainWindow.getScene().getWindow());
        dlnNewPersinContact.initModality(Modality.WINDOW_MODAL);
        dlnNewPersinContact.setOnCloseRequest(event -> {
            contacts.setAll(ContactModelBook.getContacts());
            lstContacts.refresh();
        });
        dlnNewPersinContact.showAndWait();
    }
    @FXML
    private void editContactToDialog() throws IOException {
        Stage dlnNewPersinContact = new Stage();
        dlnNewPersinContact.setTitle("Добавление контактов");
        dlnNewPersinContact.setResizable(false);
        dlnNewPersinContact.setScene(new Scene(FXMLLoader.load(getClass().getResource("/homework2/modal/dialogEdit.fxml"))));
        dlnNewPersinContact.initOwner(mainWindow.getScene().getWindow());
        dlnNewPersinContact.initModality(Modality.WINDOW_MODAL);
        dlnNewPersinContact.setOnCloseRequest(event -> {
            contacts.setAll(ContactModelBook.getContacts());
            lstContacts.refresh();
        });
        dlnNewPersinContact.showAndWait();
    }

    @FXML
    private void closeOnClick() {
        System.exit(0);
    }

    @FXML
    private void getFullInformation() {
        MultipleSelectionModel<PersonContact> langsSelectionModel = lstContacts.getSelectionModel();
        langsSelectionModel.selectedItemProperty().addListener(new ChangeListener<PersonContact>() {
            @Override
            public void changed(ObservableValue<? extends PersonContact> observable, PersonContact oldValue, PersonContact newValue) {

                txtName.setText(newValue.getName());
                txtSurname.setText(newValue.getSurname());
                txtEmail.setText(newValue.getEmail());
                txtNumber.setText(newValue.getPhone());
mesto= contacts.indexOf(newValue);
            }
        });


    }

    @FXML
    private void deleteContacte() {
        MultipleSelectionModel<PersonContact> langsSelectionModel = lstContacts.getSelectionModel();
        langsSelectionModel.selectedItemProperty().addListener(new ChangeListener<PersonContact>() {
            @Override
            public void changed(ObservableValue<? extends PersonContact> observable, PersonContact oldValue, PersonContact newValue) {

ContactModelBook.delete(lstContacts.getSelectionModel().getSelectedItem());
                contacts.setAll(ContactModelBook.getContacts());
                


            }
        });

    }



    @FXML
    private void editContacte() {
        MultipleSelectionModel<PersonContact> langsSelectionModel = lstContacts.getSelectionModel();
        langsSelectionModel.selectedItemProperty().addListener(new ChangeListener<PersonContact>() {
            @Override
            public void changed(ObservableValue<? extends PersonContact> observable, PersonContact oldValue, PersonContact newValue) {
 mesto = contacts.indexOf(observable);


                contacts.setAll(ContactModelBook.getContacts());
                lstContacts.refresh();


            }
        });
    }

}


