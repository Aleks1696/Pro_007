package javafx.lesson01.controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class MainController {
    @FXML private TextField fldLogin;
    @FXML private TextField fldPassword;
    @FXML private TextField fldConfirm;

    @FXML
    private void registrationOnClick(){
        if (fldPassword.getText().equals(fldConfirm.getText())){
            System.out.println("New User");
            System.out.println("Login: "+ fldLogin.getText());
            System.out.println("Password: "+ fldPassword.getText());
        } else {
            System.err.println("Выделенные пароли не совпадают");
        }
    }

    @FXML
    private void cancelOnClick(){
        System.exit(0);
    }
}
