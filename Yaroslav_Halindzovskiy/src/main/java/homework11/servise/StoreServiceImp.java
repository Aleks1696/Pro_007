package homework11.servise;

import homework11.dao.StoreDAO;
import homework11.dao.StoreDAOimp;
import homework11.entity.Laptop;
import homework11.entity.Store;

import java.util.Date;
import java.util.List;

public class StoreServiceImp implements StoreService {
    private StoreDAO dao;

    public StoreServiceImp() {
        dao = new StoreDAOimp();
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
        if(dao.delete(store)){
            System.out.println("Update");
        }
        else System.err.println("Crash");

    }

    @Override
    public void delete(Store store) {

    }

    @Override
    public List<Store> findAll() {
        return null;
    }

    @Override
    public Laptop sell() {
        return null;
    }

    @Override
    public Laptop findByNumberOfParty() {
        return null;
    }

    @Override
    public Laptop findLapptopByDate() {
        return null;
    }
}
