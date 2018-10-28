package lesson8.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Locale;

public class CreateTableDoctor {
    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);
        String url = "jdbc:mysql://localhost:3306/jdbc_pro007?useSSL=false";
        String user = "root";
        String pass = "root";

        try (Connection conn = DriverManager.getConnection(url,user,pass)) {
            Statement statement = conn.createStatement();
            statement.executeUpdate("CREATE TABLE DOCTORS (ID INTEGER NOT NULL, " +
                    "NAME VARCHAR (30)," +
                    "SURNAME VARCHAR (30)," +
                    "AGE INTEGER, PRIMARY KEY(ID))");

            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}