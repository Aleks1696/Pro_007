package jdbs.homework_JDBS.Task_3_with_client_authorisation;

import java.sql.*;

public class Intitial_filling_of_database {
    public static void main(String[] args) {

        User u1 = new User("David", "Kolin", "Davi", "123");

        String url = "jdbc:mysql://localhost:3306/homework_4?useSSL=false";
        String user = "myRoot";
        String pass = "root";

        try {
            Connection connection = DriverManager.getConnection(url, user, pass);
            PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO Users " +
                            "(ID, NAME, SURNAME, LOGIN, PASSWORD)" +
                            "VALUES(?,?,?,?,?)"
            );
            statement.setInt(1, u1.getId());
            statement.setString(2, u1.getName());
            statement.setString(3, u1.getSurname());
            statement.setString(4, u1.getNickName());
            statement.setString(5, u1.getPassword());

            statement.execute();
            statement.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
