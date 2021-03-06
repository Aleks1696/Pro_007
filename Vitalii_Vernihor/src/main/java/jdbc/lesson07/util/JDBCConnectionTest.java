package jdbc.lesson07.util;

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

            Connection conntion = DriverManager.getConnection(url, user, pass);
            if (conntion != null) {
                System.out.println("Соединение установлено");
                conntion.close();
            }
        } catch (ClassNotFoundException e) {
            System.err.println("Драйвер не найден");
        } catch (SQLException e) {
            System.err.println("Соединение не установлено");
        }
    }
}
