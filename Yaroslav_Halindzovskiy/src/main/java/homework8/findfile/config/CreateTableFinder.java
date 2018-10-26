package homework8.findfile.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Locale;

public class CreateTableFinder {

    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);
        String url = "jdbc:mysql://localhost:3306/jdbc_pro007?useSSL=false";
        String user  = "root";
        String pass = "root";

        try (Connection conn = DriverManager.getConnection(url,user,pass)){
            Statement statement = conn.createStatement();
            statement.executeUpdate("CREATE TABLE FINDER (RESULT varchar (300))");
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();

        }

    }

}
