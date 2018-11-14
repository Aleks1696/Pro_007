package hibernate.homework_with_IStore_part2.dao;

import hibernate.homework_with_IStore_part2.entity.Laptop;
import hibernate.homework_with_IStore_part2.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class Laptop_DAO_Impl implements Laptop_DAO {

    private SessionFactory sessionFactory;

    public Laptop_DAO_Impl() {
        sessionFactory = HibernateUtil.getFactory();
    }

    @Override
    public Long create(Laptop laptop) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            Long serialNumber = (Long) session.save(laptop);
            session.getTransaction().commit();
            return serialNumber;
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            e.printStackTrace();
            System.out.println("Error while creating laptop");
            return null;
        }
    }

    @Override
    public Laptop read(Long laptopSerialNumber) {
        Session session = sessionFactory.openSession();
        return session.get(Laptop.class, laptopSerialNumber);
    }

    @Override
    public boolean update(Laptop laptop) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.update(laptop);
            session.getTransaction().commit();
            return true;
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            System.out.println("Error while updating laptop");
            return false;
        }
    }

    @Override
    public boolean delete(Laptop laptop) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.delete(laptop);
            session.getTransaction().commit();
            return true;
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            System.out.println("Error while deleting laptop");
            return false;
        }
    }

    @Override
    public List<Laptop> findAll() {
        Session session = sessionFactory.openSession();
        return session.createCriteria(Laptop.class).list();
    }
}
