package spring.homework14.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import spring.homework14.entity.Store;

import java.util.List;
@Repository
@Transactional
public class StoreDAOimp implements StoreDAO {
    private SessionFactory factory;
@Autowired
    public StoreDAOimp(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public Long create(Store store) {
        return (Long) factory.getCurrentSession().save(store);
    }

    @Override
    public Store read(Long id) {
        return factory.getCurrentSession().get(Store.class,id);
    }

    @Override
    public void update(Store store) {
    factory.getCurrentSession().update(store);

    }

    @Override
    public void delete(Store store) {
    factory.getCurrentSession().delete(store);

    }

    @Override
    public List<Store> findAll() {
        return factory.getCurrentSession().createCriteria(Store.class).list();
    }
}
