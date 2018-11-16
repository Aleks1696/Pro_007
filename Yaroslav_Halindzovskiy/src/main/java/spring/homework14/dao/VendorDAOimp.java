package spring.homework14.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import spring.homework14.entity.Vendor;

import java.util.List;

@Repository
@Transactional
public class VendorDAOimp implements VendorDAO {
    private SessionFactory factory;

    @Autowired
    public VendorDAOimp(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public Long create(Vendor vendor) {
        return (Long) factory.getCurrentSession().save(vendor);
    }

    @Override
    public Vendor read(Long id) {
        return factory.getCurrentSession().get(Vendor.class, id);
    }

    @Override
    public void update(Vendor vendor) {
        factory.getCurrentSession().update(vendor);

    }

    @Override
    public void delete(Vendor vendor) {
        factory.getCurrentSession().delete(vendor);

    }

    @Override
    public List<Vendor> findAll() {
        return factory.getCurrentSession().createCriteria(Vendor.class).list();

    }
}
