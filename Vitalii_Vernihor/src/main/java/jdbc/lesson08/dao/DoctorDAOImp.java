package jdbc.lesson08.dao;

import jdbc.lesson08.entity.Doctor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Locale;


public class DoctorDAOImp implements DoctorDAO {

    String url = "jdbc:mysql://localhost:3306/jdbc_pro007?useSSL=false";
    String user = "root";
    String pass = "root";


    @Override
    public void create(Doctor doctor) {
        try (Connection conn = DriverManager.getConnection(url,user,pass)){
            PreparedStatement statement = conn.prepareStatement(
                    "INSERT INTO DOCTORS (ID, NAME, SURNAME, AGE) VALUE (?,?,?,?)"
            );
            statement.setInt(1,doctor.getId());
            statement.setString(2,doctor.getName());
            statement.setString(3,doctor.getSurname());
            statement.setInt(4,doctor.getAge());
            statement.execute();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Doctor read(Integer id) {
        return null;
    }

    @Override
    public void update(Doctor doctor) {

    }

    @Override
    public void deleate(Integer id) {

    }

    @Override
    public List<Doctor> findAll() {
        return null;
    }
}
