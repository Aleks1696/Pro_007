package homework2.controller;

import javafx.fxml.FXML;
import homework2.domen.PersonContact;
import homework2.model.ContactModelBook;

import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import static homework2.controller.MainControllerBook.mesto;

public class DialogEditorController {

    @FXML
    private AnchorPane dialogEdit;
    @FXML
    private TextField fldNameEdit;
    @FXML
    private TextField fldSurnameEdit;
    @FXML
    private TextField fldNumberEdit;
    @FXML
    private TextField fldEmailEdit;

    @FXML
    private  void changeOnClick() {
        System.out.println(mesto);
        ContactModelBook.change(mesto,new PersonContact(fldNameEdit.getText(),fldSurnameEdit.getText(),fldNumberEdit.getText(),fldEmailEdit.getText()));
        fldNameEdit.clear();
        fldSurnameEdit.clear();
        fldNumberEdit.clear();
        fldEmailEdit.clear();

        cancelOnClick();
    }

    @FXML
    private void cancelOnClick() {
        Stage dlg = (Stage) dialogEdit.getScene().getWindow();
        dlg.getOnCloseRequest().handle(new WindowEvent(dlg, WindowEvent.WINDOW_CLOSE_REQUEST));
        dlg.close();
    }

}
