package jdbs.homework_JDBS.Task_3_with_client_authorisation;

import java.sql.*;

public class CreateTable {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/homework_4?useSSL=false";
        String user = "myRoot";
        String pass = "root";

        Connection connection;

        {
            try {
                connection = DriverManager.getConnection(url, user, pass);
                PreparedStatement statement = connection.prepareStatement(
                        "CREATE TABLE Users " +
                                "(ID INTEGER NOT NULL," +
                                "NAME VARCHAR(30)," +
                                "SURNAME VARCHAR(50)," +
                                "LOGIN VARCHAR(30)," +
                                "PASSWORD VARCHAR(20)," +
                                "PRIMARY KEY (ID))"
                );
                statement.execute();
                statement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
