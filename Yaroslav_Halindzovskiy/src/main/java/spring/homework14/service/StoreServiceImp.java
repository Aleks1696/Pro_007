package spring.homework14.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.homework14.dao.StoreDAO;
import spring.homework14.entity.Laptop;
import spring.homework14.entity.Store;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Service
public class StoreServiceImp implements StoreService {
    private StoreDAO storeDAO;
@Autowired
    public StoreServiceImp(StoreDAO storeDAO) {
        this.storeDAO = storeDAO;
    }

    @Override
    public void sell(Long id) {
    storeDAO.delete(storeDAO.read(id));

    }

    @Override
    public List findByNumberOfParty(Long id) {
    List<Laptop> findbyNumberOfParty = new ArrayList<>();

        for (Store store: storeDAO.findAll()){

             for (Laptop laptop: store.getLaptops()){
                 if(laptop.getId().equals(id)){
                     findbyNumberOfParty.add(laptop);
                 }
             }

        }

      return findbyNumberOfParty;
    }

    @Override
    public List findLapptopByDate(Date date) {
        List<Laptop> findbyNumberOfDate = new ArrayList<>();

        for (Store store: storeDAO.findAll()){

            for (Laptop laptop: store.getLaptops()){
                if(laptop.getDate().equals(date)){
                    findbyNumberOfDate.add(laptop);
                }
            }

        }

        return findbyNumberOfDate;
    }
}
