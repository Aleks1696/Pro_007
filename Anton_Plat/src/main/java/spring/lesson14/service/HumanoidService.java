package spring.lesson14.service;

import spring.lesson13.part1.entity.Human;
import spring.lesson14.entity.Humanoid;

import java.util.List;

public interface HumanoidService {
     Long create(Humanoid humanoid);
     Humanoid get(Long id);
     void update(Humanoid humanoid);
     void delete(Humanoid humanoid);
     List<Humanoid> findAll();
}
