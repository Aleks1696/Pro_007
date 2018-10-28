package jdbc.lesson08;

import jdbc.lesson08.dao.DoctorDAO;
import jdbc.lesson08.dao.DoctorDAOImp;
import jdbc.lesson08.entity.Doctor;

import java.util.List;
import java.util.Locale;

public class DoctorTest {
    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);

        DoctorDAO doctorDAO = new DoctorDAOImp();

//        doctorDAO.create(new Doctor(1,"Barsuk","Enotovich",20));
//        doctorDAO.create(new Doctor(2,"Oleg","House",18));
//        doctorDAO.create(new Doctor(3,"Lexa","Promily",36));



        Doctor doctor = doctorDAO.read(2);
        System.out.println(doctor);

        doctor.setName("Noname");
        doctorDAO.update(doctor);

        List<Doctor> doctorList = doctorDAO.findAll();
        doctorList.forEach(System.out::println);


    }
}
