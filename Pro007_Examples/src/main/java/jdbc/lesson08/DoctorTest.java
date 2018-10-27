package jdbc.lesson08;

import jdbc.lesson08.dao.DoctorDAO;
import jdbc.lesson08.dao.DoctorDAOImp;
import jdbc.lesson08.entity.Doctor;

import java.util.List;
import java.util.Locale;

public class DoctorTest {

    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);

        DoctorDAO doctorDao = new DoctorDAOImp();

//        doctorDao.create(new Doctor(1, "Barsuk", "Enotovich", 97));
//        doctorDao.create(new Doctor(2, "Oleg", "House", 17));
//        doctorDao.create(new Doctor(3, "Lexa", "Promily", 37));

        Doctor doctor = doctorDao.read(2);
        System.out.println(doctor);

        doctor.setName("NoName");
        doctor.setSurname("China");
        doctorDao.update(doctor);

        Doctor doctor1 = doctorDao.read(2);
        System.out.println(doctor1);

        List<Doctor> doctorList = doctorDao.findAll();
        doctorList.forEach(System.out::println);


    }

}
