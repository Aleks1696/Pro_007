package spring.lesson22.dao;

import spring.lesson22.entity.Car;

public interface CarDAO {

    Long create(Car car);

    Car read(Long id);

    void update(Car car);

    void delete(Car car);

}
