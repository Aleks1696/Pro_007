package lesson8.dao;

import lesson8.entity.Doctor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class DoctorDAOImp implements DoctorDAO  {
    String url = "jdbc:mysql://localhost:3306/jdbc_pro007?useSSL=false";
    String user = "root";
    String pass = "root";

    @Override
    public void create(Doctor doctor) {
        try (Connection conn = DriverManager.getConnection(url,user,pass)){
            PreparedStatement statement = conn.prepareStatement(
                    "insert into DOCTORS (id , name ,surname,age) value (?,?,?,?)"
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
    public void delete(Integer id) {

    }

    @Override
    public List<Doctor> findAll() {
        return null;
    }
}
