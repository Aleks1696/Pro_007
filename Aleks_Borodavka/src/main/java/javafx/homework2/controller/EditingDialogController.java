package javafx.homework2.controller;

import javafx.fxml.FXML;
import javafx.homework2.domain.Contact;
import javafx.homework2.model.ContactModel;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;


public class EditingDialogController {

    @FXML
    private GridPane editingDialog;

    @FXML
    private TextField fldName;
    @FXML
    private TextField fldSurname;
    @FXML
    private TextField fldPhone;
    @FXML
    private TextField fldEmail;

    @FXML
    private void saveOnClick() {
        Stage dlg = (Stage)editingDialog.getScene().getWindow();
        int index = ContactModel.getContacts().indexOf(MainController.getActiveContact());

        ContactModel.saveAfterAditing(index, new Contact(fldName.getText(), fldSurname.getText(),
                fldPhone.getText(), fldEmail.getText()));

        fldName.clear();
        fldSurname.clear();
        fldPhone.clear();
        fldEmail.clear();

        dlg.getOnCloseRequest().
                handle(new WindowEvent(dlg, WindowEvent.WINDOW_CLOSE_REQUEST));
        dlg.close();
    }

    @FXML
    private void cancelOnClick() {
        Stage dlg = (Stage) editingDialog.getScene().getWindow();
        dlg.getOnCloseRequest().
                handle(new WindowEvent(dlg, WindowEvent.WINDOW_CLOSE_REQUEST));
        dlg.close();
    }
}


