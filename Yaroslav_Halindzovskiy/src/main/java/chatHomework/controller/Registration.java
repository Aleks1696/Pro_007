package chatHomework.controller;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;



public class Registration extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Чат Ярика 1.0");
        Parent view = FXMLLoader.load(getClass().getResource("/chatFX.fxml"));
        primaryStage.setScene(new Scene(view));
        primaryStage.show();
    }
}