package jdbs.lesson08;

import jdbs.lesson08.dao.DoctorDAO;
import jdbs.lesson08.dao.DoctorDAOImp;
import jdbs.lesson08.entity.Doctor;

import java.util.List;
import java.util.Locale;

public class DoctorTest {
    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);

        DoctorDAO doctorDAO = new DoctorDAOImp();
//        doctorDAO.create(new Doctor(1,"Borsuk", "Enotovich", 97));
//        doctorDAO.create(new Doctor(2,"Henry", "House", 68));
//        doctorDAO.create(new Doctor(3,"Oleg", "Promile", 22));

        Doctor doctor = doctorDAO.read(2);
        System.out.println(doctor);

        doctor.setName("NoName");
        doctorDAO.update(doctor);

        Doctor doctor1 = doctorDAO.read(2);
        System.out.println(doctor1);


        List<Doctor> doctorList = doctorDAO.findAll();
        doctorList.forEach(System.out::println);
    }
}
