package spring.homework14.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import spring.homework14.entity.Laptop;

import javax.transaction.Transactional;
import java.util.List;
@Repository
@Transactional
public class LaptopDAOimp implements LaptopDAO {
    private SessionFactory factory;
@Autowired
    public LaptopDAOimp(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public Long create(Laptop laptop) {
        return (Long) factory.getCurrentSession().save(laptop);
    }

    @Override
    public Laptop read(Long id) {
        return factory.getCurrentSession().get(Laptop.class,id);
    }

    @Override
    public void update(Laptop laptop) {
    factory.getCurrentSession().update(laptop);

    }

    @Override
    public void delete(Laptop laptop) {
    factory.getCurrentSession().delete(laptop);

    }

    @Override
    public List<Laptop> findAll() {
        return factory.getCurrentSession().createCriteria(Laptop.class).list();
    }
}
