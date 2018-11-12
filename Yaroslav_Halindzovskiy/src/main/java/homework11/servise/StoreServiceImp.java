package homework11.servise;

import homework11.dao.LaptopDAO;
import homework11.dao.LaptopDAOimp;
import homework11.dao.StoreDAO;
import homework11.dao.StoreDAOimp;
import homework11.entity.Laptop;
import homework11.entity.Store;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StoreServiceImp implements StoreService {
    private StoreDAO dao;
    private LaptopService laptopService;

    public StoreServiceImp() {
        dao = new StoreDAOimp();
        laptopService = new LaptopServiceImp() ;


    }



    @Override
    public Store create(Date date, Integer qantity, List<Laptop> laptops) {
        if(date!=null&qantity!=null&laptops!=null){
            Store store = new Store(date,qantity,laptops);
            store.setId(dao.create(store));
            return store;
        }
            return null;
    }

    @Override
    public Store read(Long id) {
        if(id!=null){
            return dao.read(id);
        }
        return null;
    }

    @Override
    public void update(Store store) {
        if(dao.update(store)){
            System.out.println("Update");
        }
        else System.err.println("Crash");

    }

    @Override
    public void delete(Store store) {
        if (dao.delete(store)){

        }
        else System.err.println("Crash");

    }

    @Override
    public List<Store> findAll() {


        return dao.findAll();
    }

    @Override
    public void sell(Long id) {
        for (Store store: findAll()){
          for (Laptop laptop : store.getLaptops()){
              if (laptop.getId().equals(id)){
                  laptopService.delete(laptop);
              }
          }

        }


    }

    @Override
    public List findByNumberOfParty(Long id) {
        List<Laptop> findbyParyList = new ArrayList<>();
        for (Store store: findAll()){
            for (Laptop laptop : store.getLaptops()){
                if (laptop.getId().equals(id)){
                    findbyParyList.add(laptop);
                }
            }

        }

        return null;
    }

    @Override
    public List findLapptopByDate(Date date) {
        List<Laptop> findbyParyList = new ArrayList<>();
        for (Store store: findAll()){
            for (Laptop laptop : store.getLaptops()){
                if (laptop.getDate().equals(date)){
                    findbyParyList.add(laptop);
                }
            }

        }
        return null;
    }


}
