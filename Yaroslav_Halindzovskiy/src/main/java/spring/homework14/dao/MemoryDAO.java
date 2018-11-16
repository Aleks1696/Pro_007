package spring.homework14.dao;


import spring.homework14.entity.Memory;

import java.util.List;

public interface MemoryDAO {

    Long create(Memory memory);
    Memory read(Long id);
    void update(Memory memory);
    void delete(Memory memory);
    List<Memory> findAll();
}
