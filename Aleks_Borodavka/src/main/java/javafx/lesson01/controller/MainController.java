package javafx.lesson01.controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class MainController {

    @FXML private TextField fldLogin;
    @FXML private TextField fldPassword;
    @FXML private TextField fldConfirm;

    @FXML private void registrationOnClick(){
        if (fldPassword.getText().equals(fldConfirm.getText())){
            System.out.println("New user: ");
            System.out.println("Login:: " + fldLogin.getText() + " Password: " + fldPassword.getText());
        } else {
            System.err.println("Passwords don't match");
        }
    }


    @FXML private void cancelOnClick(){
        System.exit(0);
    }

}
