package jdbs.lesson07.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnectionTest {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver is noticed");

            String url = "jdbc:mysql://localhost:3306?useSSL=false";
            String user = "myRoot";
            String pass = "root";

            Connection connection = DriverManager.getConnection(url, user, pass);
            if (connection != null){
                System.out.println("Connection installed");
                connection.close();
            }
        } catch (ClassNotFoundException e) {
            System.out.println("Driver is not found");
        } catch (SQLException e) {
            System.out.println("Connection denied");
        }
    }
}
