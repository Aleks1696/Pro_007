package lesson7;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Locale;

public class CreateDBSchema {
    public static void main(String[] args) {
        /* JDBC  - (Java Database Connection - Технология , которая позволяет нам взаимодействовать с базой данных(БД)
         * */
        Locale.setDefault(Locale.ENGLISH);
        /*Настройки подключения к БД */
        String url = "jdbc:mysql://localhost:3306?useSSL=false";
        String user = "root";
        String pass = "root";
        try (Connection conn = DriverManager.getConnection(url, user, pass)) {
            /*Класс  Statemant  позволяет подготовить запрос к выполнению БД ( тело запроса описывается на SQL )*/
            Statement statement = conn.createStatement();
            /*CREATE - обозначает запрос на создания чего либо в БД
             * SCHEMA - позволяет создать отдельную БД на MySQL Server
             * <имя_бд >*/
            statement.executeUpdate("CREATE SCHEMA  jdbc_pro007");
statement.close();
// Класс обязательно закрываем.
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
