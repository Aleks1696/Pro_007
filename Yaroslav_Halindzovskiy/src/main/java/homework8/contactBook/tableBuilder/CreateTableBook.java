package homework8.contactBook.tableBuilder;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Locale;

public class CreateTableBook {
    public static void main(String[] args) {

        Locale.setDefault(Locale.ENGLISH);
        String url = "jdbc:mysql://localhost:3306/jdbc_pro007?useSSL=false";
        String user = "root";
        String pass = "root";


        try (Connection connection = DriverManager.getConnection(url,user,pass)){
            Statement statement = connection.createStatement();
            statement.executeUpdate("CREATE TABLE BOOK (id integer  NOT null AUTO_INCREMENT,LOGIN varchar (20) UNIQUE KEY ,PASSWORD varchar (20),primary key (id))");


        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

}
