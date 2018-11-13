package spring.homework14.dao;


import spring.homework14.entity.CPU;

import java.util.List;

public interface CPUDAO {

    Long create(CPU cpu);
    CPU read(Long id);
    void update(CPU cpu);
    void delete(CPU cpu);
    List<CPU> findAll();
}
