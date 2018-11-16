package hibernate.homework_with_IStore_part2.service;

import hibernate.homework_with_IStore_part2.entity.Laptop;
import hibernate.homework_with_IStore_part2.entity.Store;

import java.util.GregorianCalendar;
import java.util.List;

public interface StoreService {

    void createNewBatch();

    boolean sellLaptopFromStore(Laptop laptop);

    List<Laptop> laptopListByBatchNumber(Long batchNumber);

    List<Laptop> laptopListByBatchDate(GregorianCalendar batchDate);

    List<Store> findAll();

}
