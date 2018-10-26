package javafx.homework1.controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class MainController {

    @FXML private TextField fldA;
    @FXML private TextField fldB;
    @FXML private TextField fldResult;

    @FXML private void plus(){
        double a = Double.parseDouble(fldA.getText());
        double b = Double.parseDouble(fldB.getText());

        fldResult.setText(Double.toString(a + b));
    }

    @FXML private void minus(){
        double a = Double.parseDouble(fldA.getText());
        double b = Double.parseDouble(fldB.getText());

        fldResult.setText(Double.toString(a - b));
    }

    @FXML private void dividing(){
        double a = Double.parseDouble(fldA.getText());
        double b = Double.parseDouble(fldB.getText());

        fldResult.setText(Double.toString(a / b));
    }

    @FXML private void multipliing(){
        double a = Double.parseDouble(fldA.getText());
        double b = Double.parseDouble(fldB.getText());

        fldResult.setText(Double.toString(a * b));
    }


}

