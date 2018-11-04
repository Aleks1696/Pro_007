package homework10.service;

import homework10.entity.Laptop;
import homework10.entity.types.Brand;

import java.util.List;

public interface LaptopServiceShow {

    List<Laptop> findByName (String name);
    List<Laptop> findByBrand (Brand brand);
    List<Laptop> findPriceAndHard (Double price, Integer hard);
    List <Laptop> findBetweenPrice(Double priceFrom, Double priceTo,Brand brand);
}
