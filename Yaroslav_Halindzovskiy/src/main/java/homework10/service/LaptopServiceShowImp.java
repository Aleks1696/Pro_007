package homework10.service;

import homework10.dao.LaptopDAO;
import homework10.dao.LaptopDAOimp;
import homework10.entity.Laptop;
import homework10.entity.types.Brand;

import java.util.List;

public class LaptopServiceShowImp implements LaptopServiceShow {
    private LaptopDAO dao;
    public LaptopServiceShowImp (){
        dao = new LaptopDAOimp();
    }
    @Override
    public List<Laptop> findByName(String name) {
        if(name!= null ){
            return dao.findByName(name);
        }

        return null;
    }

    @Override
    public List<Laptop> findByBrand(Brand brand) {
        if(brand!=null){
            return dao.findByBrand(brand);
        }
        return null;
    }

    @Override
    public List<Laptop> findPriceAndHard(Double price, Integer hard) {
        if(price!=null&& hard!=null){
          return   dao.findPriceAndHard(price,hard);

        }
        return null;
    }

    @Override
    public List<Laptop> findBetweenPrice(Double priceFrom, Double priceTo, Brand brand) {
        if(priceFrom!=null&& priceTo!= null&& brand!=null){
          return   dao.findBetweenPriceByVendor(priceFrom,priceTo,brand);
        }
        return null;
    }
}
