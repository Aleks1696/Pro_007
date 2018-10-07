package javafx.homework01.controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class MainController {
    @FXML private TextField num1;
    @FXML private TextField num2;
    @FXML private TextField result;

    @FXML
    private void plusOnClick(){
        Integer num1int = Integer.valueOf(num1.getText());
        Integer num2int = Integer.valueOf(num2.getText());
    result.setText(Integer.toString(num1int + num2int));
    }

    @FXML
    private void minusOnClick(){
        Integer num1int = Integer.valueOf(num1.getText());
        Integer num2int = Integer.valueOf(num2.getText());
        result.setText(Integer.toString(num1int - num2int));
    }

    @FXML
    private void umnozhitOnClick(){
        Integer num1int = Integer.valueOf(num1.getText());
        Integer num2int = Integer.valueOf(num2.getText());
        result.setText(Integer.toString(num1int / num2int));
    }

    @FXML
    private void delitOnClick(){
        Integer num1int = Integer.valueOf(num1.getText());
        Integer num2int = Integer.valueOf(num2.getText());
        result.setText(Integer.toString(num1int * num2int));
    }
}
