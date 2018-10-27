package javafx.homework2.controller;

import javafx.fxml.FXML;
import javafx.homework2.domain.Contact;
import javafx.homework2.model.ContactModel;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class DialogController {

    @FXML
    private GridPane dialog;

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
        ContactModel.save(new Contact(
                fldName.getText(),
                fldSurname.getText(),
                fldPhone.getText(),
                fldEmail.getText()
        ));
        fldName.clear();
        fldSurname.clear();
        fldPhone.clear();
        fldEmail.clear();
    }

    @FXML
    private void cancelOnClick() {
        Stage dlg = (Stage) dialog.getScene().getWindow();
        dlg.getOnCloseRequest().
                handle(new WindowEvent(dlg, WindowEvent.WINDOW_CLOSE_REQUEST));
        dlg.close();
    }
}
