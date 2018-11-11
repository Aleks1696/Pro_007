package homework11.dao;


import homework11.util.HibernateUtil;
import homework11.entity.Laptop;
import org.hibernate.HibernateError;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class LaptopDAOimp implements LaptopDAO{
    private SessionFactory factory;

    public LaptopDAOimp() {
        factory = HibernateUtil.getFactory();
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

}
