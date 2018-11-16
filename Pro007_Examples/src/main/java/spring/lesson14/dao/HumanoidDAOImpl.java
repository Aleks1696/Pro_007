package spring.lesson14.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import spring.lesson14.entity.Humanoid;

import java.util.List;

/* @Repository - Отмечает класс на уровне Spring Framework
*                как объект доступа к данным
*  @Transactional - подключает менеджер транзакций Spring ORM*/

@Repository
@Transactional
public class HumanoidDAOImpl implements HumanoidDAO {

    private SessionFactory factory;

    @Autowired
    public HumanoidDAOImpl(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public Long create(Humanoid humanoid) {
        return (Long) factory.getCurrentSession().save(humanoid);
    }

    @Override
    public Humanoid get(Long id) {
        return factory.getCurrentSession().get(Humanoid.class, id);
    }

    @Override
    public void update(Humanoid humanoid) {
        factory.getCurrentSession().update(humanoid);
    }

    @Override
    public void delete(Humanoid humanoid) {
        factory.getCurrentSession().delete(humanoid);
    }

    @Override
    public List<Humanoid> findAll() {
        return factory.getCurrentSession()
                .createCriteria(Humanoid.class)
                .list();
    }
}
