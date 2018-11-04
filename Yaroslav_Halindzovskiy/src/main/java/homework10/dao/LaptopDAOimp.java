package homework10.dao;

import homework10.entity.Laptop;
import homework10.entity.types.Brand;
import homework10.util.HibernateUtil;
import org.hibernate.HibernateError;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.List;

public class LaptopDAOimp implements  LaptopDAO {
    private SessionFactory factory;

    public LaptopDAOimp() {
        factory = HibernateUtil.getSessionFactory();
    }

    @Override
    public Long create(Laptop laptop) {
        Session sesion = factory.openSession();
        try {
            sesion.beginTransaction();
            Long id = (Long) sesion.save(laptop);
            sesion.getTransaction().commit();
            return id;
        } catch (HibernateError e) {
            sesion.getTransaction().rollback();
            System.err.println(e.getLocalizedMessage());
        }
        return null;
    }

    @Override
    public Laptop read(Long id) {

        return factory.openSession().get(Laptop.class, id);
    }

    @Override
    public boolean update(Laptop laptop) {
        Session session = factory.openSession();
        try {
            session.beginTransaction();
            session.update(laptop);
            session.getTransaction();
            return true;
        } catch (HibernateError error) {
            session.getTransaction().rollback();
        }
        return false;
    }

    @Override
    public boolean delete(Laptop laptop) {
        Session session = factory.openSession();
        try {
            session.beginTransaction();
            session.delete(laptop);
            session.getTransaction();
            return true;
        } catch (HibernateError error) {
            session.getTransaction().rollback();
        }
        return false;
    }

    @Override
    public List<Laptop> findAll() {
        return factory.openSession().createCriteria(Laptop.class).list();
    }

    @Override
    public List<Laptop> findByName(String name) {
        List<Laptop> listWithName = new ArrayList() {
        };
        for (Laptop laptop : findAll()) {
            if (laptop.getName().equals(name)) {
                listWithName.add(laptop);
            }
        }
        return listWithName;
    }

    @Override
    public List<Laptop> findByBrand(Brand brand) {
        List<Laptop> listWithBrand = new ArrayList();{
            for (Laptop laptop:findAll()){
                if(laptop.getBrand().equals(brand)) {
                    listWithBrand.add(laptop);
                }
            }
        }
        return listWithBrand;
    }


    @Override
    public List<Laptop> findPriceAndHard(Double price, Integer hard) {
        List<Laptop> list = new ArrayList<>();
        for(Laptop laptop:findAll()){
            if(laptop.getPrice() == price && laptop.getHardDrive()== hard){
                list.add(laptop);
            }

        }
        return list;
    }

    @Override
    public List<Laptop> findBetweenPriceByVendor(Double priceFrom, Double priceTo, Brand brand) {
        List <Laptop> laptopList = new ArrayList<>();
        for (Laptop laptop:findAll()){
            if (priceFrom<= laptop.getPrice()&&priceTo>= laptop.getPrice()&& laptop.getBrand().equals(brand)){
                laptopList.add(laptop);
            }
        }
        return laptopList;
    }
}

