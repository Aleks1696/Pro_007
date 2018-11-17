package hibernate.homework_with_IStore_part2.service;

import hibernate.homework_with_IStore_part1.entity.types.Manufacturers;
import hibernate.homework_with_IStore_part2.entity.Laptop;
import hibernate.homework_with_IStore_part2.entity.types.CPUs;
import hibernate.homework_with_IStore_part2.entity.types.RAM_Type;

import java.util.GregorianCalendar;
import java.util.List;

public interface LaptopService {

    List<Laptop> findByManufacturer(Manufacturers manufacturer);

    List<Laptop> findByManufactureDate(GregorianCalendar manufactureDate);

    List<Laptop> findByCharacteristic(CPUs cpu);

    List<Laptop> findByCharacteristic(RAM_Type ramType);


}
