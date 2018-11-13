package spring.homework14.dao;

import spring.homework14.entity.Laptop;


import java.util.List;

public interface LaptopDAO {

    Long create(Laptop laptop);
    Laptop read(Long id);
    void update(Laptop laptop);
    void delete(Laptop laptop);
    List<Laptop> findAll();

}
