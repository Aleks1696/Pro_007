package jdbs.homework_JDBS;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("InsertRootsToTable");
        String path = "/squareEquation.fxml";

        Parent parent = FXMLLoader.load(
                getClass().getResource(path)
        );
        primaryStage.setScene(new Scene(parent));
        primaryStage.show();
    }
}
