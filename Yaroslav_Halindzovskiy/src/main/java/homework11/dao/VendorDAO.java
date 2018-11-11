package homework11.dao;

import homework11.entity.types.Vendor;

import java.util.List;

public interface VendorDAO {
    Long create (Vendor vendor);
    Vendor  read (Long id);
    boolean update (Vendor vendor);
    boolean delete (Vendor vendor);
    List<Vendor> findAll();
}
