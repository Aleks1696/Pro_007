package hibernate.homework_with_IStore_part1.service;

import hibernate.homework_with_IStore_part1.entity.Laptop;
import hibernate.homework_with_IStore_part1.entity.types.Manufacturers;

import java.util.GregorianCalendar;
import java.util.List;

public interface LaptopExtraService {

    void deleteLaptop(Laptop laptop);

    void changePrice(Laptop laptop, Double newPrice);

    void changeSerialManufacturer(Laptop laptop, Manufacturers newManufacturer);

    void deleteByModel(String model);

    List<Laptop> showByManufacturer(Enum manufacturer);

    List<Laptop> showByPriceAndManufactureDate(Double price, GregorianCalendar date);

    List<Laptop> showBetweenPriceLowerThanDateAndByManufacturer(Double priceFrom,
                                                                Double priceTo,
                                                                GregorianCalendar date,
                                                                Enum manufacturer);
}
