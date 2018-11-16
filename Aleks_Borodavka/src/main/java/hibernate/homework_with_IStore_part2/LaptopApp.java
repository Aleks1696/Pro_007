package hibernate.homework_with_IStore_part2;

import hibernate.homework_with_IStore_part1.entity.types.Manufacturers;
import hibernate.homework_with_IStore_part2.dao.*;
import hibernate.homework_with_IStore_part2.entity.*;
import hibernate.homework_with_IStore_part2.entity.types.CPUs;
import hibernate.homework_with_IStore_part2.entity.types.RAM_Type;
import hibernate.homework_with_IStore_part2.service.LaptopService;
import hibernate.homework_with_IStore_part2.service.LaptopServiceImpl;
import hibernate.homework_with_IStore_part2.service.StoreService;
import hibernate.homework_with_IStore_part2.service.StoreServiceImpl;
import hibernate.homework_with_IStore_part2.util.HibernateUtil;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

public class LaptopApp {

    public static void main(String[] args) {

        Session session = HibernateUtil.getFactory().openSession();

        CPU_DAO cpuDao = new CPU_DAO_Impl();
        RAM_DAO ramDao = new RAM_DAO_Impl();
        Manufacturer_DAO manufacturerDao = new Manufacturer_DAO_Impl();
        Laptop_DAO laptopDao = new Laptop_DAO_Impl();

        CPU cpu1 = new CPU(CPUs.i7_8550U, "2,7");
        CPU cpu2 = new CPU(CPUs.i3_7350K, "2.0");
        CPU cpu3 = new CPU(CPUs.i5_8500, "4.1");
        CPU cpu4 = new CPU(CPUs.i3_7300T, "3.8");

        cpuDao.create(cpu1);
        cpuDao.create(cpu2);
        cpuDao.create(cpu3);
        cpuDao.create(cpu4);

        RAM ram1 = new RAM(RAM_Type.DDR4, 4, 2400);
        RAM ram2 = new RAM(RAM_Type.DDR4, 8, 2400);
        RAM ram3 = new RAM(RAM_Type.DDR3, 4, 1800);
        RAM ram4 = new RAM(RAM_Type.DDR3, 16, 2000);

        ramDao.create(ram1);
        ramDao.create(ram2);
        ramDao.create(ram3);
        ramDao.create(ram4);

        Manufacturer manufacturer1 = new Manufacturer(Manufacturers.DELL, "The best manufacturer");
        Manufacturer manufacturer2 = new Manufacturer(Manufacturers.APPLE, "This is Apple");
        Manufacturer manufacturer3 = new Manufacturer(Manufacturers.LENOVO, "China");
        Manufacturer manufacturer4 = new Manufacturer(Manufacturers.ACER, "Not bad");

        manufacturerDao.create(manufacturer1);
        manufacturerDao.create(manufacturer2);
        manufacturerDao.create(manufacturer3);
        manufacturerDao.create(manufacturer4);

//      Creates new batch but does't commit it
        Store batch1 = batch1 = new Store(new GregorianCalendar(2018, 11, 14));


        Laptop laptop1 = new Laptop(cpu1, ram1, manufacturer1, 23000.12,
                new GregorianCalendar(2018, 3, 12), batch1);

        //Making dependencies between laptop and cpu,ram,manufacturer
        cpu1.getLaptopListWithCPU().add(laptop1);
        ram1.getLaptopListWithRAM().add(laptop1);
        manufacturer1.getLaptopListByManufacturer().add(laptop1);

        Laptop laptop2 = new Laptop(cpu2, ram2, manufacturer2, 28000.72,
                new GregorianCalendar(2018, 6, 23), batch1);

        cpu2.getLaptopListWithCPU().add(laptop2);
        ram2.getLaptopListWithRAM().add(laptop2);
        manufacturer2.getLaptopListByManufacturer().add(laptop2);

        Laptop laptop3 = new Laptop(cpu3, ram3, manufacturer3, 13000.42,
                new GregorianCalendar(2011, 26, 22), batch1);

        cpu3.getLaptopListWithCPU().add(laptop3);
        ram3.getLaptopListWithRAM().add(laptop3);
        manufacturer3.getLaptopListByManufacturer().add(laptop3);

        Laptop laptop4 = new Laptop(cpu4, ram4, manufacturer4, 43000.18,
                new GregorianCalendar(2018, 10, 2), batch1);

        cpu4.getLaptopListWithCPU().add(laptop4);
        ram4.getLaptopListWithRAM().add(laptop4);
        manufacturer4.getLaptopListByManufacturer().add(laptop4);

//      adds all laptops to list
        List<Laptop> laptopListAtBathc1 = new ArrayList<>();
        laptopListAtBathc1.add(laptop1);
        laptopListAtBathc1.add(laptop2);
        laptopListAtBathc1.add(laptop3);
        laptopListAtBathc1.add(laptop4);

//      adds all laptops to batch number 1
        batch1.setLaptopListFromBatch(laptopListAtBathc1);
        batch1.setAmountAtStore(laptopListAtBathc1.size());
        session.beginTransaction();
        session.save(batch1);
        session.getTransaction().commit();

//      commits laptops to BD
        laptopDao.create(laptop1);
        laptopDao.create(laptop2);
        laptopDao.create(laptop3);
        laptopDao.create(laptop4);

//      checks dependencies
        System.out.println(cpu1.getLaptopListWithCPU());
        System.out.println(manufacturer2.getLaptopListByManufacturer());

//      laptop service check
        LaptopService laptopService = new LaptopServiceImpl();
        System.out.println(laptopService.findByCharacteristic(CPUs.i3_7300T));

//      store service check
        StoreService storeService = new StoreServiceImpl();
        System.out.println(storeService.laptopListByBatchNumber(9L));
        System.out.println(storeService.sellLaptopFromStore(laptop2));
        System.out.println(storeService.laptopListByBatchDate(new GregorianCalendar(2018, 11, 14)));


        HibernateUtil.getFactory().close();
    }
}
