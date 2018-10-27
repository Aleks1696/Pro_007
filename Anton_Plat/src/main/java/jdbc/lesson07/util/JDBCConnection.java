package jdbc.lesson07.util;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnection {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Драйвер обнаружен!");

            String url = "jdbc:mysql://localhost:3306?useSSL=false";
            String user = "root";
            String pass = "root";

            Connection connection =
                    DriverManager.getConnection(url, user, pass);
            if(connection != null){
                System.out.println("Соединение установлено.");
                connection.close();
            }
        } catch (ClassNotFoundException e) {
            System.out.println("Драйвер не найден");
        }catch (SQLException e) {
            System.out.println("Соединение не установлено");
        }
    }
}