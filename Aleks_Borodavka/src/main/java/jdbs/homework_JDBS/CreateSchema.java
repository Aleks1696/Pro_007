package jdbs.homework_JDBS;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Locale;

public class CreateSchema {
    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);

        String url = "jdbc:mysql://localhost:3306?useSSL=false";
        String user = "myRoot";
        String pass = "root";

        try {
            Connection connection = DriverManager.getConnection(url, user, pass);

            Statement statement = connection.createStatement();
            statement.executeLargeUpdate("CREATE SCHEMA homework_4");
            statement.close();

            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
