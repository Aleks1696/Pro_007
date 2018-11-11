package homework11.dao;

import homework11.entity.Laptop;


import java.util.List;

public interface LaptopDAO {

    Long create (Laptop laptop);
    Laptop read (Long id);
    boolean update (Laptop laptop);
    boolean delete (Laptop laptop);
    List<Laptop> findAll();

}
