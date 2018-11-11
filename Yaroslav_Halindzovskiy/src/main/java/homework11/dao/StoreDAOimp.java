package homework11.dao;

import homework11.entity.Store;
import org.hibernate.HibernateError;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class StoreDAOimp implements StoreDAO {
    private SessionFactory factory;
    @Override
    public Long create(Store store) {
        Session session = factory.openSession();
        try{
            session.beginTransaction();
            Long id =(long) session.save(store);
            session.getTransaction().commit();
            return id;

        }catch (HibernateError e){
            session.getTransaction().rollback();

        }
        return null;
    }

    @Override
    public Store read(Long id) {
        return factory.openSession().get(Store.class,id);
    }

    @Override
    public boolean update(Store store) {
        Session session = factory.openSession();
        try{
            session.beginTransaction();
            session.update(store);
            session.getTransaction();
            return true;

        }catch (HibernateError error){
            session.getTransaction().rollback();
        }
        return false;
    }

    @Override
    public boolean delete(Store store) {
        Session session = factory.openSession();
        try {
            session.beginTransaction();
            session.delete(store);
            session.getTransaction();
        }catch (HibernateError error){
            session.getTransaction().rollback();
        }
        return false;
    }

    @Override
    public List<Store> findAll() {
        return factory.openSession().createCriteria(Store.class).list();
    }
}
