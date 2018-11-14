package spring.lesson14.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.lesson14.dao.HumanoidDAO;
import spring.lesson14.entity.Humanoid;

import java.util.List;

@Service
public class HumanoidServiceImpl implements HumanoidService {

    private HumanoidDAO humanoidDAO;

    @Autowired
    public HumanoidServiceImpl(HumanoidDAO humanoidDAO) {
        this.humanoidDAO = humanoidDAO;
    }
    @Override
    public Long create(Humanoid humanoid) {
        return humanoidDAO.create(humanoid);
    }
    @Override
    public Humanoid get(Long id) {
        return humanoidDAO.get(id);
    }
    @Override
    public void update(Humanoid humanoid) {
        humanoidDAO.update(humanoid);
    }
    @Override
    public void delete(Humanoid humanoid) {
        humanoidDAO.delete(humanoid);
    }
    @Override
    public List<Humanoid> findAll() {
        return humanoidDAO.findAll();
    }
}
