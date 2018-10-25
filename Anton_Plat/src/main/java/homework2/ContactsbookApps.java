package homework2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ContactsbookApps  extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Мой записник");
        primaryStage.setResizable(false);
        Parent main = FXMLLoader.load((getClass().getResource("homework2/main.fxml")));
        primaryStage.setScene(new Scene(main));
        primaryStage.show();


    }
}