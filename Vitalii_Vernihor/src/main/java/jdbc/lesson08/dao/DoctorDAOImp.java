package jdbc.lesson08.dao;

import com.sun.xml.internal.bind.v2.model.core.ID;
import jdbc.lesson08.entity.Doctor;

import java.sql.*;
import java.util.ArrayList;
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
        try (Connection conn = DriverManager.getConnection(url, user, pass)) {
            PreparedStatement statement = conn.prepareStatement("SELECT  * FROM DOCTORS WHERE ID = ?");
            statement.setInt(1, id);
            ResultSet set = statement.executeQuery();
            Doctor doctor = new Doctor();

            while (set.next()) {
                doctor.setId(set.getInt("ID"));
                doctor.setName(set.getString("NAME"));
                doctor.setSurname(set.getString("SURNAME"));
                doctor.setAge(set.getInt("AGE"));
            }
            statement.close();
            return doctor;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void update(Doctor doctor) {

    }

    @Override
    public void deleate(Integer id) {

    }

    @Override
    public List<Doctor> findAll() {
        try (Connection conn = DriverManager.getConnection(url,user,pass)){
            PreparedStatement statement = conn.prepareStatement(
                    "SELECT  * FROM DOCTORS"
            );
            ResultSet set = statement.executeQuery();
            List<Doctor> doctors = new ArrayList<>();
            while (set.next()){
                doctors.add(new Doctor(
                        set.getInt("ID"),
                        set.getString("NAME"),
                        set.getString("SURNAME"),
                        set.getInt("AGE")
                    )
                );
            }
            statement.close();
            return doctors;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
