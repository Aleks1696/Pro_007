package homework11.dao;

import homework11.entity.types.Memory;

import java.util.List;

public interface MemoryDAO {

    Long create (Memory memory);
    Memory read (Long id);
    boolean update (Memory memory);
    boolean delete (Memory memory);
    List<Memory> findAll();
}
