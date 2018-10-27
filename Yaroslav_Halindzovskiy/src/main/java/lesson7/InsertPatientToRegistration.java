package lesson7;

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
        String user = "root";
        String pass = "root";
        /* PreparedStatemant */
        try (Connection conn = DriverManager.getConnection(url, user, pass)) {
            PreparedStatement statement = conn.prepareStatement("INSERT INTO REGISTRATION (ID,NAME,SURNAME, AGE )");

            List<Patient> patients = new ArrayList<>();
            patients.add(new Patient(100, "Napoleon ", "Bonapard", 75));
            patients.add(new Patient(200, "Adolf ", "Hitler", 40));
            patients.add(new Patient(300, "Vasya ", "Quest", 29));
patients.forEach(patient -> {
    try {
        statement.setInt(1,patient.getId());
        statement.setString(2,patient.getName());
        statement.setString(3,patient.getSurname());
        statement.setInt(4,patient.getAge());
        statement.execute();
        System.out.println("Создана запись : " + patient);
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
