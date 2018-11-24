package spring.lesson14.dao;

import spring.lesson14.entity.Humanoid;

import java.util.List;

public interface HumanoidDAO {
    Long create(Humanoid humanoid);
    Humanoid get(Long id);
    void update(Humanoid humanoid);
    void delete(Humanoid humanoid);
    List<Humanoid> findAll();

}
