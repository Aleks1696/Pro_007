package spring.homework14.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.homework14.dao.LaptopDAO;
import spring.homework14.entity.Laptop;

import java.util.Date;
import java.util.List;

@Service
public class LaptopServiceImp  implements LaptopService{
    private LaptopDAO laptopDAO;
    @Autowired
    public LaptopServiceImp(LaptopDAO laptopDAO) {
        this.laptopDAO = laptopDAO;
    }




    @Override
    public Long create(Laptop laptop) {
        return laptopDAO.create(laptop);
    }

    @Override
    public Laptop read(Long id) {
        return laptopDAO.read(id);
    }

    @Override
    public void update(Laptop laptop) {
    laptopDAO.update(laptop);

    }

    @Override
    public void delete(Laptop laptop) {
    laptopDAO.delete(laptop);

    }

    @Override
    public List<Laptop> findAll() {
        return laptopDAO.findAll();
    }

    @Override
    public List<Laptop> findByVendor(String vendor) {
        return null;
    }

    @Override
    public List<Laptop> findByPrice(Double price) {
        return null;
    }

    @Override
    public List<Laptop> findByDate(Date date) {
        return null;
    }

    @Override
    public List<Laptop> findByCpuFrequence(Double frequence) {
        return null;
    }
}
