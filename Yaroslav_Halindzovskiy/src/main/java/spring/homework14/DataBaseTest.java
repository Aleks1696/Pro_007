package spring.homework14;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring.homework14.dao.LaptopDAO;
import spring.homework14.entity.*;
import spring.homework14.entity.enums.CPUenum;
import spring.homework14.entity.enums.MemoryTypes;
import spring.homework14.service.LaptopService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DataBaseTest {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring/homework14/config.xml");

        CPU cpu1 = new CPU(CPUenum.Intel, 4.3);
        CPU cpu2 = new CPU(CPUenum.Amd, 1.5);
        CPU cpu3 = new CPU(CPUenum.Intel, 2.0);
        CPU cpu4 = new CPU(CPUenum.Amd, 2.0);

        Memory memory1 = new Memory(MemoryTypes.DDR2, 24.0);
        Memory memory2 = new Memory(MemoryTypes.DDR2, 24.0);
        Memory memory3 = new Memory(MemoryTypes.DDR3, 24.0);
        Memory memory4 = new Memory(MemoryTypes.DDR4, 24.0);

        Vendor vendor1 = new Vendor("XXX", " Apple Incorporation");
        Vendor vendor2 = new Vendor("XXX", "lenovo IBM Company");

        Laptop laptop1 = new Laptop(999.99, new Date(2015, 12, 11), cpu1, memory1, vendor1);
        Laptop laptop2 = new Laptop(1000.0, new Date(2017, 6, 23), cpu2, memory2, vendor1);
        Laptop laptop3 = new Laptop(123.0, new Date(2018, 2, 14), cpu3, memory3, vendor2);
        Laptop laptop4 = new Laptop(500.0, new Date(2012, 1, 10), cpu4, memory4, vendor2);

        LaptopService  service = context.getBean(LaptopService.class);
        service.create(laptop1);
        service.create(laptop2);
        service.create(laptop3);
        service.create(laptop4);



        List<Laptop> laptops1 = new ArrayList<>();
        laptops1.add(laptop1);
        laptops1.add(laptop2);
        laptops1.add(laptop3);
        List<Laptop> laptops2 = new ArrayList<>();
        laptops2.add(laptop2);
        laptops2.add(laptop3);
        laptops2.add(laptop4);

        Store store1 = new Store(laptop1.getDate(),5,laptops1);
        Store store2= new Store(laptop3.getDate(),100,laptops2);
        Store store3 = new Store(laptop4.getDate(),5);


    }
}
