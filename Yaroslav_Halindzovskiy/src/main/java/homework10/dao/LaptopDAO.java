package homework10.dao;

import homework10.entity.Laptop;
import homework10.entity.types.Brand;

import java.util.List;

public interface LaptopDAO{


    Long create (Laptop laptop);
    Laptop read (Long id);
    boolean update (Laptop laptop);
    boolean delete (Laptop laptop);
    List<Laptop> findAll();
    List <Laptop> findByName(String name);
    List <Laptop> findByBrand (Brand brand);
    List <Laptop> findPriceAndHard(Double price,Integer hard);
    //* Получить список ноутбуков по Цене в указанном диапазоне, меньше указанной Даты выпуска и указанного Производителя.
    List<Laptop> findBetweenPriceByVendor(Double priceFrom, Double priceTo, Brand brand);


}


