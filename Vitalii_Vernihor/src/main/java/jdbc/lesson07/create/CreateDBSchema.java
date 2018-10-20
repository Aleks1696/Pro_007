package jdbc.lesson07.create;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Locale;

public class CreateDBSchema {
    public static void main(String[] args) {
        // JDBC - Java DataBase Connection - технология которая позволяет нам взаимодействовать с базой данных
        Locale.setDefault(Locale.ENGLISH);
        // Настройки подключения к БД
        String url = "jdbc:mysql://localhost:3306?useSSL=false";
        String user = "root";
        String pass = "root";
        // установка соединения
        try (Connection conn = DriverManager.getConnection(url, user, pass)){
            // класс statement позволяет на подготовить запрос к выполнению БД (тело запроса на SQL)
            Statement statement = conn.createStatement();
            // CREATE - запрос на создание чего-либо
            // SCHEMA - позволяет создать отдельную БД на MySQL Server
            // <имя_бд>
            // jdbc_pro007 - название бд, может быть любым
            statement.executeUpdate("CREATE SCHEMA jdbc_pro007");
            // после выполнения Statement класс обязательно закрываем
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
