package jdbs.lesson07.insert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class InsertPatientToRegistration {

    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);
        String url = "jdbc:mysql://localhost:3306/jdbc_pro007?useSSL=false";
        String user = "myRoot";
        String pass = "root";
        try (Connection conn = DriverManager.getConnection(url, user, pass)) {
            /*PreparedStatement - позволяет создать SQL шаблон запроса
             * */
            PreparedStatement statement =
                    conn.prepareStatement(
                            "INSERT INTO REGISTRATION " +
                                    "(ID, NAME, SURNAME, AGE) " +
                                    "VALUES (?,?,?,?)");
            List<Patient> patientList = new ArrayList<>();
            patientList.add(new Patient(100, "Napoleon", "Bonapart", 75));
            patientList.add(new Patient(200, "Adolf", "Hitler", 40));
            patientList.add(new Patient(300, "Ron", "Gil", 25));

            patientList.forEach(patient -> {
                try {
                    statement.setInt(1, patient.getId());
                    statement.setString(2, patient.getName());
                    statement.setString(3, patient.getSurname());
                    statement.setInt(4, patient.getAge());

                    statement.execute();
                    System.out.println("Created: " + patient);

                    statement.clearParameters();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            });

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
