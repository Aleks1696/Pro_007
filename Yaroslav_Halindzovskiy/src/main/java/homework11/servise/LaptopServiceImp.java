package homework11.servise;

import homework11.dao.LaptopDAO;
import homework11.dao.LaptopDAOimp;
import homework11.entity.Laptop;
import homework11.entity.types.CPU;
import homework11.entity.types.Memory;
import homework11.entity.types.Vendor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LaptopServiceImp implements LaptopService {
    private LaptopDAO dao;
    public LaptopServiceImp(){
        dao = new LaptopDAOimp();
    }
    @Override
    public Laptop create(Double price, Date date, CPU cpu, Memory memory, Vendor vendor) {
        if(price!=null&date!=null&cpu!=null&memory!=null&vendor!=null){
            Laptop laptop = new Laptop(price,date,cpu,memory,vendor);
            laptop.setId(dao.create(laptop));
            return laptop;
        }
        throw new  IllegalStateException();

    }

    @Override
    public Laptop read(Long id) {
        if(id!=null){
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

    @Override
    public List<Laptop> findByVendor(String vendorName) {
        List<Laptop> vendorList = new ArrayList<>();
        for(Laptop laptop:findAll()){
            if(laptop.getVendor().getName().equals(vendorName)){
                vendorList.add(laptop);
            }
        }

        return vendorList;
    }

    @Override
    public List<Laptop> findByPrice(Double price) {
        List<Laptop> priceList = new ArrayList<>();
        for (Laptop laptop : findAll()) {
            if (laptop.getPrice().equals(price)) {
                priceList.add(laptop);
            }
        }
            return priceList;

    }

    @Override
    public List<Laptop> findByDate(Date date) {
        List<Laptop> dateList = new ArrayList<>();
        for (Laptop laptop : findAll()) {
            if (laptop.getDate().equals(date)) {
                dateList.add(laptop);
            }
        }
        return dateList;
    }

    @Override
    public List<Laptop> findByCpuFrequence(Double frequence) {
        List<Laptop> freauenceList = new ArrayList<>();
        for (Laptop laptop : findAll()) {
            if (laptop.getCpu().getFrequence().equals(frequence)) {

                freauenceList.add(laptop);
            }
        }
        return freauenceList;
    }
}
