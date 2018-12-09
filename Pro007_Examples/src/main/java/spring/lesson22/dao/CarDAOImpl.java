package spring.lesson22.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import spring.lesson22.entity.Car;

@Repository
@Transactional
public class CarDAOImpl implements CarDAO {

    private SessionFactory sessionFactory;

    @Autowired
    public CarDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Long create(Car car) {
        return (Long) sessionFactory
                .getCurrentSession()
                .save(car);
    }

    @Override
    public Car read(Long id) {
        return sessionFactory
                .getCurrentSession()
                .get(Car.class, id);
    }

    @Override
    public void update(Car car) {
        sessionFactory
                .getCurrentSession()
                .update(car);
    }

    @Override
    public void delete(Car car) {

    }
}
