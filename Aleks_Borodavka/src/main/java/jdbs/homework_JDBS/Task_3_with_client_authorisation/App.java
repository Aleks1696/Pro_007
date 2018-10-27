package jdbs.homework_JDBS.Task_3_with_client_authorisation;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Authorization");
        primaryStage.setResizable(false);

        Parent parent = FXMLLoader.load(
                getClass().getResource("/jdbs/homework_JDBS/usersAuthentification.fxml")
        );
        primaryStage.setScene(new Scene(parent));
        primaryStage.show();

    }
}
