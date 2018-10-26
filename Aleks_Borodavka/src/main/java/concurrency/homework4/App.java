package concurrency.homework4;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("File Reader");

        Parent parent = FXMLLoader.load(
                getClass().getResource("/concurrency/homework4/main.fxml")
        );
        primaryStage.setScene(new Scene(parent));
        primaryStage.show();
    }
}
