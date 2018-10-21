package lesson8;

import lesson8.dao.DoctorDAO;
import lesson8.dao.DoctorDAOImp;
import lesson8.entity.Doctor;

import java.util.Locale;

public class DoctorTest {
    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);
        DoctorDAO doctorDAO = new DoctorDAOImp();

        doctorDAO.create(new Doctor(1,"Barsuk", "Enotovich", 97));
        doctorDAO.create(new Doctor(2,"Oleg", "House", 17));
        doctorDAO.create(new Doctor(3,"lex", "Promily", 37));
    }
}
