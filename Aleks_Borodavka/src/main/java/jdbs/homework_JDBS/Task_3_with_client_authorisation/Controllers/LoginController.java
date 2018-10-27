package jdbs.homework_JDBS.Task_3_with_client_authorisation.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;

public class LoginController {

    @FXML
    private TextField fldLogin;
    @FXML
    private TextField fldPassword;

    private String url = "jdbc:mysql://localhost:3306/homework_4?useSSL=false";
    private String user = "myRoot";
    private String pass = "root";


    @FXML
    private void logIn() {

        try (Connection connection = DriverManager.getConnection(url, user, pass)) {
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT * FROM Users " +
                            "WHERE LOGIN = ? " +
                            "AND" +
                            " PASSWORD = ?");
            statement.setString(1, fldLogin.getText());
            statement.setString(2, fldPassword.getText());
            ResultSet set = statement.executeQuery();

            if (set.next()) {
                openUsersInfoWindow();
            }
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    private void openUsersInfoWindow() {
        Stage stage = new Stage();
        stage.setTitle("Users list");
        stage.setResizable(false);

        try {
            stage.setScene(new Scene(FXMLLoader.load(
                    getClass().getResource("/jdbs/homework_JDBS/usersInfo.fxml")
            )));
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.show();
    }
}


