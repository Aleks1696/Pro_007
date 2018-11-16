package hibernate.homework_with_IStore_part2.dao;

import hibernate.homework_with_IStore_part2.entity.Manufacturer;
import hibernate.homework_with_IStore_part2.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class Manufacturer_DAO_Impl implements Manufacturer_DAO {

    private SessionFactory sessionFactory;

    public Manufacturer_DAO_Impl() {
        sessionFactory = HibernateUtil.getFactory();
    }

    @Override
    public Long create(Manufacturer manufacturer) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.save(manufacturer);
            session.getTransaction().commit();
            return null;
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            System.out.println("Error while creating manufacturer");
            return null;
        }
    }

    @Override
    public Manufacturer read(Long manufacturerName) {
        Session session = sessionFactory.openSession();
        return session.get(Manufacturer.class, manufacturerName);
    }

    @Override
    public boolean update(Manufacturer manufacturer) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.update(manufacturer);
            session.getTransaction().commit();
            return true;
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            System.out.println("Error while updating manufacturer");
            return false;
        }
    }

    @Override
    public boolean delete(Manufacturer manufacturer) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.delete(manufacturer);
            session.getTransaction().commit();
            return true;
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            System.out.println("Error while deleting manufacturer");
            return false;
        }
    }

    @Override
    public List<Manufacturer> findAll() {
        Session session = sessionFactory.openSession();
        return session.createCriteria(Manufacturer.class).list();
    }
}
