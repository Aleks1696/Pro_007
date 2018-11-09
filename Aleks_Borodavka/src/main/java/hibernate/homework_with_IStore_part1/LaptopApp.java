package hibernate.homework_with_IStore_part1;

import hibernate.homework_with_IStore_part1.entity.Laptop;
import hibernate.homework_with_IStore_part1.entity.types.Manufacturers;
import hibernate.homework_with_IStore_part1.service.LaptopExtraService;
import hibernate.homework_with_IStore_part1.service.LaptopExtraServiceImpl;
import hibernate.homework_with_IStore_part1.service.LaptopService;
import hibernate.homework_with_IStore_part1.service.LaptopServiceImpl;
import hibernate.homework_with_IStore_part1.util.HibernateUtil;

import java.util.GregorianCalendar;
import java.util.List;

public class LaptopApp {

    public static void main(String[] args) {

        LaptopService service = new LaptopServiceImpl();
        LaptopExtraService extraService = new LaptopExtraServiceImpl();


        Laptop laptop1 = new Laptop(235135,
                Manufacturers.ACER,
                "Aspire 10X",
                new GregorianCalendar(2018, 0, 23),
                24999.00
        );

        Laptop laptop2 = new Laptop(1234214,
                Manufacturers.DELL,
                "XPS 13",
                new GregorianCalendar(2018, 6,21),
                34000.00
        );

        Laptop laptop3 = new Laptop(32151,
                Manufacturers.LENOVO,
                "IdeaPad15",
                new GregorianCalendar(2017, 4,31),
                18499.99
        );

        service.create(laptop1);
        service.create(laptop2);
        service.create(laptop3);

        extraService.changePrice(laptop1, 2300.00);

        System.out.println(service.read(laptop3.getId()));

        service.update(laptop2);
        extraService.changeSerialManufacturer(laptop3, Manufacturers.HP);
        extraService.deleteByModel("XPS 13");
        List<Laptop> list = extraService.showByManufacturer(Manufacturers.ACER);
        System.out.println(list);
        List<Laptop> list1 = extraService.showByPriceAndManufactureDate(23600.00,
                new GregorianCalendar(2018, 0, 23));
        System.out.println(list1);


        HibernateUtil.getFactory().close();
    }

}
