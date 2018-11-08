package hibernate.homework_with_IStore_part1.dao;

import hibernate.homework_with_IStore_part1.entity.Laptop;

import java.util.GregorianCalendar;
import java.util.List;

public interface LaptopDAO {

    Long create(Laptop laptop);

    Laptop read(Long id);

    boolean update(Laptop laptop);

    boolean delete(Laptop laptop);

    List<Laptop> findByModel(String model);

    List<Laptop> findByManufacturer(Enum manufacturer);

    List<Laptop> findByPriceAndManufactureDate(Double price, GregorianCalendar manufactureDate);

    List<Laptop> findBetweenPriceLowerThanDateAndByManufacturer(Double priceFrom,
                                                                Double priceTo,
                                                                GregorianCalendar date,
                                                                Enum manufacturer);

    List<Laptop> findAll();

}
