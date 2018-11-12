package homework11;

import homework11.entity.Laptop;
import homework11.entity.Store;
import homework11.entity.types.CPU;
import homework11.entity.types.Memory;
import homework11.entity.types.Vendor;
import homework11.entity.types.enums.CPUenum;
import homework11.entity.types.enums.MemoryTypes;
import homework11.servise.StoreService;
import homework11.servise.StoreServiceImp;
import homework11.util.HibernateUtil;
import org.hibernate.Session;
import org.omg.CORBA.DATA_CONVERSION;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class HomeWork11App {
    public static void main(String[] args) {

        StoreService serviceStore = new StoreServiceImp();

        Session session = HibernateUtil.getFactory().openSession();
        CPU cpu1 = new CPU(CPUenum.Intel,4.3);
        CPU cpu2 = new CPU(CPUenum.Amd,1.5);
        CPU cpu3 = new CPU(CPUenum.Intel,2.0);
        CPU cpu4 = new CPU(CPUenum.Amd,2.0);

        session.beginTransaction();
        session.save(cpu1);
        session.save(cpu2);
        session.save(cpu3);
        session.save(cpu4);
        session.getTransaction().commit();

        session.beginTransaction();

        Memory memory1 = new Memory(MemoryTypes.DDR2,24.0);
        Memory memory2 = new Memory(MemoryTypes.DDR2,24.0);
        Memory memory3 = new Memory(MemoryTypes.DDR3,24.0);
        Memory memory4 = new Memory(MemoryTypes.DDR4,24.0);
        session.save(memory1);
        session.save(memory2);
        session.save(memory3);
        session.save(memory4);
        session.getTransaction().commit();


        Vendor vendor1 = new Vendor("Apple"," Apple Incorporation");
        Vendor vendor2 = new Vendor("Lenovo", "lenovo IBM Company");
        session.beginTransaction();
        session.save(vendor1);
        session.save(vendor2);
        session.getTransaction().commit();

        Laptop laptop1 = new Laptop(999.99,new Date(2015,12,11),cpu1,memory1,vendor1);
        Laptop laptop2 = new Laptop(1000.0,new Date(2017,6,23),cpu2,memory2,vendor1);
        Laptop laptop3 = new Laptop(123.0,new Date(2018,2,14),cpu3,memory3,vendor2);
        Laptop laptop4 = new Laptop(500.0,new Date(2012,1,10),cpu4,memory4,vendor2);

        session.beginTransaction();
        session.save(laptop1);
        session.save(laptop2);
        session.save(laptop3);
        session.save(laptop4);

        List<Laptop> laptops1 = new ArrayList<>();
        laptops1.add(laptop1);
        laptops1.add(laptop2);
        laptops1.add(laptop3);
        List<Laptop> laptops2 = new ArrayList<>();
        laptops2.add(laptop2);
        laptops2.add(laptop3);

        session.getTransaction().commit();
        Store store1 = new Store(laptop1.getDate(),5,laptops1);
        Store store2= new Store(laptop3.getDate(),100,laptops2);
        Store store3 = new Store(laptop4.getDate(),5);

        session.beginTransaction();
        session.save(store1);
        session.save(store2);
        session.save(store3);
        session.getTransaction().commit();

        session.beginTransaction();


        HibernateUtil.getFactory().close();
    }
}
