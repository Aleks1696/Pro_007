package hibernate.homework_with_IStore_part2.service;

import hibernate.homework_with_IStore_part2.dao.*;
import hibernate.homework_with_IStore_part2.entity.Laptop;
import hibernate.homework_with_IStore_part2.entity.Store;
import hibernate.homework_with_IStore_part2.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

public class StoreServiceImpl implements StoreService {

    CPU_DAO cpuDao;
    RAM_DAO ramDao;
    Manufacturer_DAO manufacturerDao;
    Laptop_DAO laptopDao;
    SessionFactory sessionFactory;

    public StoreServiceImpl() {
        sessionFactory = HibernateUtil.getFactory();
        cpuDao = new CPU_DAO_Impl();
        ramDao = new RAM_DAO_Impl();
        manufacturerDao = new Manufacturer_DAO_Impl();
        laptopDao = new Laptop_DAO_Impl();
    }

    @Override
    public void createNewBatch() {

    }

    @Override
    public boolean sellLaptopFromStore(Laptop laptop) {
        List<Store> storeList = findAll();
        List<Laptop> laptopList = new ArrayList<>();
        for (Store store : storeList) {
            laptopList.addAll(store.getLaptopListFromBatch());
            for (Laptop laptop1 : laptopList) {
                if (laptop1.getSerialNumber().equals(laptop.getSerialNumber())) {
                    laptopDao.delete(laptop);
                    return true;
                }
            }
            laptopList.clear();
        }
        return false;
    }

    @Override
    public List<Laptop> laptopListByBatchNumber(Long batchNumber) {
        List<Store> storeList = findAll();
        List<Laptop> laptopListByBatchNumber = new ArrayList<>();
        for (Store store : storeList) {
            if (store.getBatchNumber().equals(batchNumber)) {
                laptopListByBatchNumber.addAll(store.getLaptopListFromBatch());
            }
        }
        return laptopListByBatchNumber;
    }

    @Override
    public List<Laptop> laptopListByBatchDate(GregorianCalendar batchDate) {
        List<Store> laptopList = findAll();
        List<Laptop> laptopListByBatchNumber = new ArrayList<>();
        for (Store store : laptopList) {
            if (store.getReceivingDate().equals(batchDate)) {
                laptopListByBatchNumber.addAll(store.getLaptopListFromBatch());
            }
        }
        return laptopListByBatchNumber;
    }

    @Override
    public List<Store> findAll() {
        Session session = sessionFactory.openSession();
        return session.createCriteria(Store.class).list();
    }
}
