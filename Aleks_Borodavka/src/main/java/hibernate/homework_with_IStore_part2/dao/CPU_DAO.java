package hibernate.homework_with_IStore_part2.dao;

import hibernate.homework_with_IStore_part2.entity.CPU;

import java.util.List;

public interface CPU_DAO {

    Long create(CPU cpu);

    CPU read(Long cpuSerialNumber);

    boolean update(CPU cpu);

    boolean delete(CPU cpu);

    List<CPU> findAll();
}
