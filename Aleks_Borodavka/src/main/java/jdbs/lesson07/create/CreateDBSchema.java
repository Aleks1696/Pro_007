package jdbs.lesson07.create;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Locale;

public class CreateDBSchema {
    public static void main(String[] args) {

        /*JDBC (Java Database Connection) - технология которая позволяет
         * нам взаимодействовать с базой данных (БД)*/
        Locale.setDefault(Locale.ENGLISH);

        String url = "jdbc:mysql://localhost:3306?useSSL=false";
        String user = "myRoot";
        String pass = "root";
        /*Устанавливаем соединение*/
        try(Connection conn = DriverManager.getConnection(url, user, pass)){
            /*Класс Statement позволяет нам подготовить запрос к выполнению БД
             * (тело зпроса описывается на SQL) */

            Statement statement = conn.createStatement();
            /*CREATE обозначает запрос на создание чего либо в БД
             * jdbc_pro007 - название БД (может быть любым)*/
            statement.executeLargeUpdate("CREATE SCHEMA jdbc_pro007");
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
