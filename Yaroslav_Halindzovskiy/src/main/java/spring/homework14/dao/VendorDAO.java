package spring.homework14.dao;

import spring.homework14.entity.Vendor;

import java.util.List;

public interface VendorDAO {
    Long create(Vendor vendor);
    Vendor  read(Long id);
    void update(Vendor vendor);
    void delete(Vendor vendor);
    List<Vendor> findAll();
}
