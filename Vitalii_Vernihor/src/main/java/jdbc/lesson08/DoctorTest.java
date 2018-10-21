package jdbc.lesson08;

import jdbc.lesson08.dao.DoctorDAO;
import jdbc.lesson08.dao.DoctorDAOImp;
import jdbc.lesson08.entity.Doctor;

import java.util.Locale;

public class DoctorTest {

    public static void main(String[] args) {

        Locale.setDefault(Locale.ENGLISH);


        DoctorDAO doctorDao = new DoctorDAOImp();

        doctorDao.create(new Doctor(1,"Barsuk","Enotovich",97));
        doctorDao.create(new Doctor(2,"Oleg","House",17));
        doctorDao.create(new Doctor(3,"Lexa","Promille",37));



    }

}
