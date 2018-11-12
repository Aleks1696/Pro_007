package spring.lesson14.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import spring.lesson14.entity.Humanoid;

import javax.transaction.Transactional;
import java.util.List;


/*
*   @Repository - Отмечает класс на уровне Spring Framework как обьект доступа к данным
*
*   @Transaction - подлючает менеджер транзакция Spring ORM
*
* */

@Repository
@Transactional
public class HumanoidDAOImp  implements HumanoidDAO{

    private SessionFactory factory;
@Autowired
    public HumanoidDAOImp(SessionFactory factory) {
        this.factory = factory;
    }





    @Override
    public Long create(Humanoid humanoid) {
        return null;
    }

    @Override
    public Humanoid get(Long id) {
        return null;
    }

    @Override
    public void update(Humanoid humanoid) {

    }

    @Override
    public void delete(Humanoid humanoid) {

    }

    @Override
    public List<Humanoid> findAll() {
        return null;
    }
}
