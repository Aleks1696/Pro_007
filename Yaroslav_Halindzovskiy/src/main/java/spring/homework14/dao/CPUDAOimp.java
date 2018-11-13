package spring.homework14.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import spring.homework14.entity.CPU;

import javax.transaction.Transactional;
import java.util.List;
@Repository
@Transactional

public class CPUDAOimp implements  CPUDAO {
    private SessionFactory factory;
@Autowired
    public CPUDAOimp(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public Long create(CPU cpu) {
        return (Long) factory.getCurrentSession().save(cpu);
    }

    @Override
    public CPU read(Long id) {
        return factory.getCurrentSession().get(CPU.class,id);
    }

    @Override
    public void update(CPU cpu) {
    factory.getCurrentSession().update(cpu);
    }

    @Override
    public void delete(CPU cpu) {
    factory.getCurrentSession().delete(cpu);
    }

    @Override
    public List<CPU> findAll() {
        return factory.getCurrentSession().createCriteria(CPU.class).list();
    }
}
