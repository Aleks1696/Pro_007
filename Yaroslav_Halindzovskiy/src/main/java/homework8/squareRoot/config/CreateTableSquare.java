package homework8.squareRoot.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Locale;

public class CreateTableSquare {

    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);
        String url = "jdbc:mysql://localhost:3306/jdbc_pro007?useSSL=false";
        String user = "root";
        String pass = "root";

        try (Connection connection = DriverManager.getConnection(url,user,pass)){
            Statement statement = connection.createStatement();


            statement.executeUpdate("CREATE TABLE SQUARED (RESULT VARCHAR (100))");
//     statement.executeUpdate("CREATE TABLE SQUARE (ID INTEGER NOT NULL , RESULT VARCHAR (30), primary key )")
       statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
