package spring.homework14.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import spring.homework14.entity.Memory;

import java.util.List;
@Repository
@Transactional
public class MemoryDAOimp implements MemoryDAO {
    private SessionFactory factory;
@Autowired
    public MemoryDAOimp(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public Long create(Memory memory) {
        return (Long) factory.getCurrentSession().save(memory);
    }

    @Override
    public Memory read(Long id) {
        return factory.getCurrentSession().get(Memory.class,id);
    }

    @Override
    public void update(Memory memory) {
    factory.getCurrentSession().update(memory);

    }

    @Override
    public void delete(Memory memory) {
    factory.getCurrentSession().delete(memory);

    }

    @Override
    public List<Memory> findAll() {
        return factory.getCurrentSession().createCriteria(Memory.class).list();
    }
}
