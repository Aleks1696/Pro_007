package hibernate.homework_with_IStore_part1.service;

import hibernate.homework_with_IStore_part1.entity.Laptop;

import java.util.List;

public interface LaptopService {

    Long create(Laptop laptop);

    Laptop read(Long id);

    boolean update(Laptop laptop);

    boolean delete(Laptop laptop);

    List<Laptop> findAll();

}
