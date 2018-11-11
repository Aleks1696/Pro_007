package homework11.dao;

import homework11.entity.types.Memory;
import org.hibernate.HibernateError;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class MemoryDAOimp implements MemoryDAO {
    private SessionFactory factory;
    @Override
    public Long create(Memory memory) {
        Session session = factory.openSession();
        try{
            session.beginTransaction();
            Long id =(long) session.save(memory);
            session.getTransaction().commit();
            return id;

        }catch (HibernateError e){
            session.getTransaction().rollback();

        }
        return null;
    }

    @Override
    public Memory read(Long id) {
        return factory.openSession().get(Memory.class,id);
    }

    @Override
    public boolean update(Memory memory) {
        Session session = factory.openSession();
        try{
            session.beginTransaction();
            session.update(memory);
            session.getTransaction();
            return true;

        }catch (HibernateError error){
            session.getTransaction().rollback();
        }
        return false;
    }

    @Override
    public boolean delete(Memory memory) {
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
    public List<Memory> findAll() {
        return factory.openSession().createCriteria(Memory.class).list();
    }
}
