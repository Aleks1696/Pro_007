package javafx.homework02;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ContactsListApp extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Книга контактов");
        primaryStage.setResizable(false);

        Parent main = FXMLLoader.load(
                getClass().getResource("/javafx/homework02/main.fxml")
        );

        primaryStage.setScene(new Scene(main));
        primaryStage.show();
    }
}
