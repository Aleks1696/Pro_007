package jdbc.lesson08.dao;

import jdbc.lesson08.entity.Doctor;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DoctorDAOImp implements DoctorDAO {

    String url = "jdbc:mysql://localhost:3306/jdbc_pro007?useSSL=false";
    String username = "root";
    String password = "root";

    @Override
    public void create(Doctor doctor) {
        try(Connection con =
                    DriverManager.getConnection(url, username, password)){
            PreparedStatement statement = con.prepareStatement(
                    "insert into doctors (id, name, surname, age) value (?,?,?,?)"
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
        try (Connection con =
                     DriverManager.getConnection(url, username, password)) {
            PreparedStatement statement = con.prepareStatement(
                    "select * from doctors where id = ?"
            );
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
            try (Connection con =
                         DriverManager.getConnection(url, username, password)) {
                PreparedStatement statement = con.prepareStatement(
                        "update doctors set name = ?, surname = ?, age = ? where id = ?"
                );

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
        try (Connection con =
                     DriverManager.getConnection(url, username, password)) {
            PreparedStatement statement = con.prepareStatement(
                    "select * from doctors"
            );
            ResultSet set = statement.executeQuery();
            List<Doctor> doctors = new ArrayList<>();
            while (set.next()) {
                doctors.add(
                        new Doctor(
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
    } }
