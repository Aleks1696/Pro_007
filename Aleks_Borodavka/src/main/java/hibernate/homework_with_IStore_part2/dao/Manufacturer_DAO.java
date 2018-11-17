package hibernate.homework_with_IStore_part2.dao;

import hibernate.homework_with_IStore_part2.entity.Manufacturer;

import java.util.List;

public interface Manufacturer_DAO {

    Long create(Manufacturer manufacturer);

    Manufacturer read(Long manufacturerName);

    boolean update(Manufacturer manufacturer);

    boolean delete(Manufacturer manufacturer);

    List<Manufacturer> findAll();

}
