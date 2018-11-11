package homework11.dao;

import homework11.entity.types.CPU;
import org.hibernate.HibernateError;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class CPUDAOimp  implements CPUDAO{
    private SessionFactory factory;
    @Override
    public Long create(CPU cpu) {
        Session sesion = factory.openSession();
        try {
            sesion.beginTransaction();
            Long id = (Long) sesion.save(cpu);
            sesion.getTransaction().commit();
            return id;
        } catch (HibernateError e) {
            sesion.getTransaction().rollback();
            System.err.println(e.getLocalizedMessage());
        }
        return null;
    }

    @Override
    public CPU read(Long id) {
        return factory.openSession().get(CPU.class, id);
    }

    @Override
    public boolean update(CPU cpu) {
        Session session = factory.openSession();
        try {
            session.beginTransaction();
            session.update(cpu);
            session.getTransaction();
            return true;
        } catch (HibernateError error) {
            session.getTransaction().rollback();
        }
        return false;
    }

    @Override
    public boolean delete(CPU cpu) {
        Session session = factory.openSession();
        try {
            session.beginTransaction();
            session.delete(cpu);
            session.getTransaction();
            return true;
        } catch (HibernateError error) {
            session.getTransaction().rollback();
        }
        return false;
    }

    @Override
    public List<CPU> findAll() {
        return factory.openSession().createCriteria(CPU.class).list();
    }
}
