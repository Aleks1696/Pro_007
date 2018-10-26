package jdbs.lesson08.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Locale;

public class CreateTableDoctor {
    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);

        String url = "jdbc:mysql://localhost:3306/jdbc_pro007?useSSL=false";
        String user = "myRoot";
        String pass = "root";

        try(Connection conn = DriverManager.getConnection(url, user, pass)) {

            Statement statement = conn.createStatement();
            statement.executeUpdate(
                    "create table doctors (" +
                            "id integer not null, " +
                            "name varchar (30)," +
                            "surname varchar(30)," +
                            "age integer," +
                            "primary key (id))"
            );
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
