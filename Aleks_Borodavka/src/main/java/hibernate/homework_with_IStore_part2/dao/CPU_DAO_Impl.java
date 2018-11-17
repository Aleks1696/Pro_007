package hibernate.homework_with_IStore_part2.dao;

import hibernate.homework_with_IStore_part2.entity.CPU;
import hibernate.homework_with_IStore_part2.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class CPU_DAO_Impl implements CPU_DAO{

    private SessionFactory sessionFactory;

    public CPU_DAO_Impl() {
        sessionFactory = HibernateUtil.getFactory();
    }

    @Override
    public Long create(CPU cpu) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            Long cpuSerialNumber = (Long) session.save(cpu);
            session.getTransaction().commit();
            return cpuSerialNumber;
        } catch (HibernateException e){
            session.getTransaction().rollback();
            System.out.println("Error while creating cpu");
            return null;
        }

    }

    @Override
    public CPU read(Long cpuSerialNumber) {
        Session session = sessionFactory.openSession();
        return session.get(CPU.class, cpuSerialNumber);
    }

    @Override
    public boolean update(CPU cpu) {
        Session session = sessionFactory.openSession();
        try{
            session.beginTransaction();
            session.update(cpu);
            session.getTransaction().commit();
            return true;
        } catch (HibernateException e){
            session.getTransaction().rollback();
            System.out.println("Error while updating cpu");
            return false;
        }
    }

    @Override
    public boolean delete(CPU cpu) {
        Session session = sessionFactory.openSession();
        try{
            session.beginTransaction();
            session.delete(cpu);
            session.getTransaction().commit();
            return true;
        } catch (HibernateException e){
            session.getTransaction().rollback();
            System.out.println("Error while deleting cpu");
            return false;
        }
    }

    @Override
    public List<CPU> findAll() {
            Session session = sessionFactory.openSession();
            return session.createCriteria(CPU.class).list();
    }
}
