package homework2.controller;

import javafx.fxml.FXML;
import homework2.domen.PersonContact;
import homework2.model.ContactModelBook;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;


public class DialogBookController {

    @FXML
    private GridPane dialog;

    @FXML
    private TextField fldName;
    @FXML
    private TextField fldSurname;
    @FXML
    private TextField fldNumber;
    @FXML
    private TextField fldEmail;

    @FXML
    private void saveOnClick() {
        ContactModelBook.save(new PersonContact(fldName.getText(), fldSurname.getText(), fldNumber.getText(), fldEmail.getText()));
       fldName.clear();
       fldSurname.clear();
       fldNumber.clear();
       fldEmail.clear();
       cancelOnClock();
    }
    @FXML
    private void cancelOnClock () {
        Stage dlg = (Stage) dialog.getScene().getWindow();
        dlg.getOnCloseRequest().handle(new WindowEvent(dlg,WindowEvent.WINDOW_CLOSE_REQUEST));
        dlg.close();
    }


}
