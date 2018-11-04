package homework10.service;


import homework10.dao.LaptopDAO;
import homework10.dao.LaptopDAOimp;
import homework10.entity.Laptop;
import homework10.entity.types.Brand;
import homework10.entity.types.CPU;
import homework10.entity.types.VideoCard;
import homework10.service.LaptopServise;

import java.util.List;

public class LaptopServiceImp implements LaptopServise {
    private LaptopDAO dao;
    public LaptopServiceImp(){
        dao = new LaptopDAOimp();}
    @Override
    public Laptop create(String name, Brand brand, double price, CPU cpu, VideoCard videoCard, int hardDrive) {
        if(name!=null&brand!=null& cpu!=null& videoCard!=null ){
            Laptop laptop = new Laptop(name,brand,price,cpu,videoCard,hardDrive);
            laptop.setId(dao.create(laptop));
            return laptop;
        }
        throw  new IllegalStateException();
    }

    @Override
    public Laptop read(Long id) {
        if ( id !=null){
            return dao.read(id);
        }

        return null;
    }

    @Override
    public void update(Laptop laptop) {
        if (dao.update(laptop)){
            System.out.println("Update");
        }
        else System.err.println("Crash");

    }

    @Override
    public void delete(Laptop laptop) {
        if ( dao.delete(laptop)){
            System.out.println("Deleted");

        }
        else System.err.println("Crash");

    }

    @Override
    public List<Laptop> findAll() {
        return dao.findAll();
    }
}
