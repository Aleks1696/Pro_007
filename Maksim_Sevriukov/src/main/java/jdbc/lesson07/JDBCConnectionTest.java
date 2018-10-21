package jdbc.lesson07;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnectionTest {

    public static void main(String[] args) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                System.out.println("Драйвер обнаружен!");

                String url = "jdbc:mysql://localhost:3306?useSSL=false";
                String user = "root";
                String pass = "root";

                Connection connection =
                        DriverManager.getConnection(url, user, pass);
                if (connection != null){
                    System.out.println("Соединение");
                    connection.close();
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                System.err.println("соединение не установлено");
            }
    }

}
