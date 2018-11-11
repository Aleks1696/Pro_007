package homework11.dao;

import homework11.entity.types.CPU;

import java.util.List;

public interface CPUDAO {

    Long create (CPU cpu);
    CPU read (Long id);
    boolean update (CPU cpu);
    boolean delete (CPU cpu);
    List<CPU> findAll();
}
