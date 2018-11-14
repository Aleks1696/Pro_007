package hibernate.homework_with_IStore_part2.dao;


import hibernate.homework_with_IStore_part2.entity.RAM;

import java.util.List;

public interface RAM_DAO {

    Long create(RAM ram);

    RAM read(Long ramSerialNumber);

    boolean update(RAM ram);

    boolean delete(RAM ram);

    List<RAM> findAll();

}
