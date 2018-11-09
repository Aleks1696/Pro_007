package hibernate.homework_with_IStore_part1.service;

import hibernate.homework_with_IStore_part1.dao.LaptopDAO;
import hibernate.homework_with_IStore_part1.dao.LaptopDAOIml;
import hibernate.homework_with_IStore_part1.entity.Laptop;

import java.util.List;

public class LaptopServiceImpl implements LaptopService {

    private LaptopDAO dao;

    public LaptopServiceImpl(){
        dao = new LaptopDAOIml();
    }

    @Override
    public Long create(Laptop laptop) {
        return dao.create(laptop);
    }

    @Override
    public Laptop read(Long id) {
        return dao.read(id);
    }

    @Override
    public boolean update(Laptop laptop) {
        return dao.update(laptop);
    }

    @Override
    public boolean delete(Laptop laptop) {
        return dao.delete(laptop);
    }

    @Override
    public List<Laptop> findAll() {
        return dao.findAll();
    }
}
