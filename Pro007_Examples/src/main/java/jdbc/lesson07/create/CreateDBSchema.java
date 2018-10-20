package jdbc.lesson07.create;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Locale;

public class CreateDBSchema {

    public static void main(String[] args) {
        /*JDBC (Java Database Connection) - технология которая
        * позволяет нам взаимодействовать с базой данных(БД)*/
        Locale.setDefault(Locale.ENGLISH);
        /* Настройки подключения к БД */
        String url = "jdbc:mysql://localhost:3306?useSSL=false";
        String user = "root";
        String pass = "root";
        /* Устанавливаем соеденение */
        try (Connection conn = DriverManager.getConnection(url, user, pass)) {
            /*Класс Statement позволяет нам подготовить запрос к
            * выполнению БД (тело запроса описывается на SQL*/
            Statement statement = conn.createStatement();
            /*CREATE - обозначает запрос на создания чего либо в БД
            * SCHEMA - позволяет создать отдельную БД на MySQL Server
            * <имя_бд>
            * jdbc_pro007 - название БД (может быть любым)*/
            statement.executeUpdate("CREATE SCHEMA jdbc_pro007");
            /* После выполнения Statement класс обязательно закрываем*/
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
