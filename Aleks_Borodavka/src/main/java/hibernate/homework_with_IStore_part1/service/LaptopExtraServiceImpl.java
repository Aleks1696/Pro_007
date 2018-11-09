package hibernate.homework_with_IStore_part1.service;

import hibernate.homework_with_IStore_part1.dao.LaptopDAO;
import hibernate.homework_with_IStore_part1.dao.LaptopDAOIml;
import hibernate.homework_with_IStore_part1.entity.Laptop;
import hibernate.homework_with_IStore_part1.entity.types.Manufacturers;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

public class LaptopExtraServiceImpl implements LaptopExtraService {

    LaptopDAO dao;

    public LaptopExtraServiceImpl() {
        dao = new LaptopDAOIml();
    }

    @Override
    public void deleteLaptop(Laptop laptop) {
        dao = new LaptopDAOIml();
        dao.delete(laptop);
    }

    @Override
    public void changePrice(Laptop laptop, Double newPrice) {
        laptop.setPrice(newPrice);
        dao.update(laptop);
    }

    @Override
    public void changeSerialManufacturer(Laptop laptop, Manufacturers newManufacturer) {
        laptop.setManufacturer(newManufacturer);
        dao.update(laptop);
    }

    @Override
    public void deleteByModel(String model) {
        List<Laptop> listOfLaptops = dao.findAll();
        for (Laptop laptop : listOfLaptops) {
            if (laptop.getModel().equals(model)) {
                dao.delete(laptop);
            }
        }
    }

    @Override
    public List<Laptop> showByManufacturer(Enum manufacturer) {
        List<Laptop> listOfLaptops = dao.findAll();
        List<Laptop> listOfLaptopsByManufacturer = new ArrayList<>();
        for (Laptop laptop : listOfLaptops) {
            if (laptop.getManufacturer().equals(manufacturer)) {
                listOfLaptopsByManufacturer.add(laptop);
            }
        }
        return listOfLaptopsByManufacturer;
    }

    @Override
    public List<Laptop> showByPriceAndManufactureDate(Double price, GregorianCalendar date) {
        List<Laptop> listOfLaptops = dao.findAll();
        List<Laptop> listOfLaptopsByPriceAndManufactureDate = new ArrayList<>();

        for (Laptop laptop : listOfLaptops) {
            if (laptop.getPrice().equals(price) && laptop.getManufactureDate().equals(date)) {
                listOfLaptopsByPriceAndManufactureDate.add(laptop);
            }
        }
        return listOfLaptopsByPriceAndManufactureDate;
    }

    @Override
    public List<Laptop> showBetweenPriceLowerThanDateAndByManufacturer(Double priceFrom,
                                                                       Double priceTo,
                                                                       GregorianCalendar date,
                                                                       Enum manufacturer) {
        List<Laptop> listOfLaptops = dao.findAll();
        List<Laptop> listOfLaptopsBetweenPriceLowerThanDateAndByManufacturer = new ArrayList<>();

        for (Laptop laptop : listOfLaptops) {
            if ((laptop.getPrice() >= priceFrom &&
                    laptop.getPrice() <= priceTo) &&
                    laptop.getManufactureDate().compareTo(date) < 0) {
                listOfLaptopsBetweenPriceLowerThanDateAndByManufacturer.add(laptop);
            }
        }
        return listOfLaptopsBetweenPriceLowerThanDateAndByManufacturer;
    }
}
