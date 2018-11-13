package spring.homework14.dao;


import spring.homework14.entity.Store;

import java.util.List;

public interface StoreDAO {
Long create(Store store);
    Store  read(Long id);
        void update(Store store);
        void delete(Store store);
        List<Store > findAll();
}
