package hibernate.homework_with_IStore_part1.dao;

import hibernate.homework_with_IStore_part1.entity.Laptop;
import hibernate.homework_with_IStore_part1.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

public class LaptopDAOIml implements LaptopDAO {

    SessionFactory sessionFactory;

    public LaptopDAOIml() {
        sessionFactory = HibernateUtil.getFactory();
    }

    @Override
    public Long create(Laptop laptop) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            Long id = (Long) session.save(laptop);
            session.getTransaction().commit();
            return id;
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            System.out.println(e.getLocalizedMessage());
            return null;
        }
    }

    @Override
    public Laptop read(Long id) {
        Session session = sessionFactory.openSession();
        return session.get(Laptop.class, id);
    }

    @Override
    public boolean update(Laptop laptop) {
        Session session = sessionFactory.openSession();
        try{
            session.beginTransaction();
            session.update(laptop);
            session.getTransaction().commit();
            return true;
        } catch (HibernateException e){
            session.getTransaction().rollback();
            return false;
        }
    }

    @Override
    public boolean delete(Laptop laptop) {
        Session session = sessionFactory.openSession();
        try{
            session.beginTransaction();
            session.delete(laptop);
            session.getTransaction().commit();
            return true;
        } catch (HibernateException e){
            session.getTransaction().rollback();
            return false;
        }
    }

    @Override
    public List<Laptop> findByModel(String model) {
        List<Laptop> laptopListByModel = new ArrayList<>();
        for (Laptop laptop : findAll()){
            if (laptop.getModel().equals(model)){
                laptopListByModel.add(laptop);
            }
        }
        return laptopListByModel;
    }

    @Override
    public List<Laptop> findByManufacturer(Enum manufacturer) {
        List<Laptop> laptopListByManufacturer = new ArrayList<>();
        for (Laptop laptop : findAll()){
            if (laptop.getManufacturer().equals(manufacturer)){
                laptopListByManufacturer.add(laptop);
            }
        }
        return laptopListByManufacturer;
    }

    @Override
    public List<Laptop> findByPriceAndManufactureDate(Double price, GregorianCalendar manufactureDate) {
        List<Laptop> laptopListByPriceAndManufactureDate = new ArrayList<>();
        for (Laptop laptop : findAll()){
            if (laptop.getPrice().equals(price)
                    & laptop.getManufactureDate().equals(manufactureDate) ){
                laptopListByPriceAndManufactureDate.add(laptop);
            }
        }
        return laptopListByPriceAndManufactureDate;
    }

    @Override
    public List<Laptop> findBetweenPriceLowerThanDateAndByManufacturer(Double priceFrom,
                                                                       Double priceTo,
                                                                       GregorianCalendar date,
                                                                       Enum manufacturer) {
        List<Laptop> laptopListByPriceRangeAndManufactureDateAndManufacturer = new ArrayList<>();
        for (Laptop laptop : findAll()){
            if (laptop.getPrice() >= priceFrom & laptop.getPrice() <= priceTo
                    & laptop.getManufactureDate().equals(date)
                    & laptop.getManufacturer().equals(manufacturer)){
                laptopListByPriceRangeAndManufactureDateAndManufacturer.add(laptop);
            }
        }
        return laptopListByPriceRangeAndManufactureDateAndManufacturer;
    }

    @Override
    public List<Laptop> findAll() {
        Session session = sessionFactory.openSession();
        return session.createCriteria(Laptop.class).list();
    }
}
