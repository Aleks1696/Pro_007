package hibernate.homework_with_IStore_part2.dao;

import hibernate.homework_with_IStore_part2.entity.Laptop;

import java.util.List;

public interface Laptop_DAO {

    Long create(Laptop laptop);

    Laptop read(Long laptopSerialNumber);

    boolean update(Laptop laptop);

    boolean delete(Laptop laptop);

    List<Laptop> findAll();
}
