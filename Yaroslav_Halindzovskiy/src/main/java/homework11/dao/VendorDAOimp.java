package homework11.dao;

import homework11.entity.types.Vendor;
import org.hibernate.HibernateError;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class VendorDAOimp implements VendorDAO{
    private SessionFactory factory;
    @Override
    public Long create(Vendor vendor) {
        Session session = factory.openSession();
        try{
            session.beginTransaction();
            Long id =(long) session.save(vendor);
            session.getTransaction().commit();
            return id;

        }catch (HibernateError e){
            session.getTransaction().rollback();

        }
        return null;
    }

    @Override
    public Vendor read(Long id) {
        return factory.openSession().get(Vendor.class,id);
    }

    @Override
    public boolean update(Vendor vendor) {
        Session session = factory.openSession();
        try{
            session.beginTransaction();
            session.update(vendor);
            session.getTransaction();
            return true;

        }catch (HibernateError error){
            session.getTransaction().rollback();
        }
        return false;
    }

    @Override
    public boolean delete(Vendor memory) {
        Session session = factory.openSession();
        try {
            session.beginTransaction();
            session.delete(memory);
            session.getTransaction();
        }catch (HibernateError error){
            session.getTransaction().rollback();
        }
        return false;
    }

    @Override
    public List<Vendor> findAll() {
        return factory.openSession().createCriteria(Vendor.class).list();
    }
}
