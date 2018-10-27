package jdbc.homework08.task2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Locale;

public class CreateDBTable {
    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);
        String url = "jdbc:mysql://localhost:3306/jdbc_pro007?useSSL=false";
        String user = "root";
        String pass = "root";

        try (Connection conn = DriverManager.getConnection(url, user, pass)){
            Statement statement = conn.createStatement();
            // CREATE TABLE <имя таблицы > - позволяет создать таблицу в бд

            statement.executeUpdate("CREATE TABLE FOUND_FILES (ID INTEGER NOT NULL, FILENAME VARCHAR(255), FILE_PATH VARCHAR(1024), PRIMARY KEY(ID))");
            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
