package lesson8.dao;

import lesson8.entity.Doctor;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DoctorDAOImp implements DoctorDAO {
    String url = "jdbc:mysql://localhost:3306/jdbc_pro007?useSSL=false";
    String user = "root";
    String pass = "root";

    @Override
    public void create(Doctor doctor) {
        try (Connection conn = DriverManager.getConnection(url, user, pass)) {
            PreparedStatement statement = conn.prepareStatement(
                    "insert into DOCTORS (id , name ,surname,age) value (?,?,?,?)"
            );
            statement.setInt(1, doctor.getId());
            statement.setString(2, doctor.getName());
            statement.setString(3, doctor.getSurname());
            statement.setInt(4, doctor.getAge());
            statement.execute();
            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Doctor read(Integer id) {
        try (Connection conn = DriverManager.getConnection(url, user, pass)) {
            PreparedStatement statement = conn.prepareStatement("select * from DOCTORS where id = ?");
            statement.setInt(1, id);
            ResultSet set = statement.executeQuery();
            Doctor doctor = new Doctor();
            while (set.next()) {
                doctor.setId(set.getInt("ID"));
                doctor.setName(set.getString("name"));
                doctor.setSurname(set.getString("SURNAME"));
                doctor.setAge(set.getInt("AGE"));
            }
            return doctor;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }


    }


    @Override
    public void update(Doctor doctor) {
        try (Connection conn = DriverManager.getConnection(url, user, pass)) {
            PreparedStatement statement = conn.prepareStatement("update doctors set name = ? , surname = ? , age = ?  where id = ? ");

            statement.setString(1, doctor.getName());
            statement.setString(2, doctor.getSurname());
            statement.setInt(3, doctor.getAge());
            statement.setInt(4, doctor.getId());
            statement.executeUpdate();
            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();

        }

    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public List<Doctor> findAll() {
        try (Connection conn = DriverManager.getConnection(url, user, pass)) {
            PreparedStatement statement = conn.prepareStatement("select * from DOCTORS ");
            ResultSet set = statement.executeQuery();
            List<Doctor> doctors = new ArrayList<>();
            while (set.next()) {
                doctors.add(new Doctor(set.getInt("ID"),
                        set.getString("NAME"),
                        set.getString("SURNAME"),
                        set.getInt("AGE")));
            }

            statement.close();
            return doctors;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }
}
