package jdbs.homework_JDBS.Task_3_with_client_authorisation.Controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import jdbs.homework_JDBS.Task_3_with_client_authorisation.User;
import jdbs.homework_JDBS.Task_3_with_client_authorisation.UsersModel;

import java.sql.*;

public class MainController {

    private static User activeUser;

    public static User getActiveUser() {
        return activeUser;
    }

    //Current user information
    @FXML
    private TextField fldCurrentID;
    @FXML
    private TextField fldCurrentName;
    @FXML
    private TextField fldCurrentSurname;
    @FXML
    private TextField fldCurrentNickName;

    //New user information
    @FXML
    private TextField fldNewName;
    @FXML
    private TextField fldNewSurname;
    @FXML
    private TextField fldNewNickName;
    @FXML
    private TextField fldPassword;

    @FXML
    private ListView<User> lstView;

    private ObservableList<User> observableList;

    private String url = "jdbc:mysql://localhost:3306/homework_4?useSSL=false";
    private String user = "myRoot";
    private String pass = "root";


    @FXML
    private void initialize() {
        User u1 = new User();

        try (Connection connection = DriverManager.getConnection(url, user, pass)) {
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT * FROM Users");

            ResultSet set = statement.executeQuery();
            while (set.next()) {
                UsersModel.getUserList().add(
                        new User(set.getString("NAME"),
                                set.getString("SURNAME"),
                                set.getString("LOGIN"),
                                set.getString("PASSWORD"))
                );
            }
            statement.close();
            observableList = FXCollections.observableArrayList(UsersModel.getUserList());
            lstView.setItems(observableList);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void activeUser() {
        clearCurrentUserFields();

        lstView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                String selectedContact = lstView.getSelectionModel().getSelectedItems().toString();
                for (User user : UsersModel.getUserList()) {
                    if (selectedContact.contains(user.getName()) &&
                            selectedContact.contains(user.getSurname())) {
                        activeUser = user;
                        infoPanelShowDetail();
                    }
                }
            }
        });
    }

    private void infoPanelShowDetail() {
        fldCurrentID.setText(String.valueOf(activeUser.getId()));
        fldCurrentName.setText(activeUser.getName());
        fldCurrentSurname.setText(activeUser.getSurname());
        fldCurrentNickName.setText(activeUser.getNickName());

    }

    @FXML
    private void addNewUser() {
        User user1 = new User(fldNewName.getText(),
                fldNewSurname.getText(),
                fldNewNickName.getText(),
                fldPassword.getText());

        try (Connection connection = DriverManager.getConnection(url, user, pass)) {
            PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO Users " +
                            "(ID, NAME, SURNAME, LOGIN, PASSWORD)" +
                            "VALUES(?,?,?,?,?)"
            );
            statement.setInt(1, user1.getId());
            statement.setString(2, user1.getName());
            statement.setString(3, user1.getSurname());
            statement.setString(4, user1.getNickName());
            statement.setString(5, user1.getPassword());

            statement.execute();
            statement.close();

            UsersModel.getUserList().add(user1);
            clearCurrentUserFields();
            observableList.clear();
            observableList.setAll(UsersModel.getUserList());
            lstView.refresh();
            clearInfoGridPane();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void clearInfoGridPane() {
        fldNewName.clear();
        fldNewSurname.clear();
        fldNewNickName.clear();
        fldPassword.clear();
    }

    private void clearCurrentUserFields() {
        fldCurrentID.clear();
        fldCurrentName.clear();
        fldCurrentSurname.clear();
        fldCurrentNickName.clear();
    }


}
