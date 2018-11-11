package homework11.dao;

import homework11.entity.Store;

import java.util.List;

public interface StoreDAO {
Long create (Store store);
    Store  read (Long id);
        boolean update (Store store );
        boolean delete (Store store );
        List<Store > findAll();
}
