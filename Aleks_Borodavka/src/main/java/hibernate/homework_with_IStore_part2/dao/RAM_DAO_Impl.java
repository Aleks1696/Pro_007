package hibernate.homework_with_IStore_part2.dao;

import hibernate.homework_with_IStore_part2.entity.RAM;
import hibernate.homework_with_IStore_part2.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class RAM_DAO_Impl implements RAM_DAO {

    private SessionFactory sessionFactory;

    public RAM_DAO_Impl() {
        sessionFactory = HibernateUtil.getFactory();
    }

    @Override
    public Long create(RAM ram) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            Long ramSerialNumber = (Long) session.save(ram);
            session.getTransaction().commit();
            return ramSerialNumber;
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            System.out.println("Error while creating ram");
            return null;
        }
    }

    @Override
    public RAM read(Long ramSerialNumber) {
        Session session = sessionFactory.openSession();
        return session.get(RAM.class, ramSerialNumber);
    }

    @Override
    public boolean update(RAM ram) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.update(ram);
            session.getTransaction().commit();
            return true;
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            System.out.println("Error while updating ram");
            return false;
        }
    }

    @Override
    public boolean delete(RAM ram) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.delete(ram);
            session.getTransaction().commit();
            return true;
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            System.out.println("Error while deleting ram");
            return false;
        }
    }

    @Override
    public List<RAM> findAll() {
        Session session = sessionFactory.openSession();
        return session.createCriteria(RAM.class).list();
    }
}
