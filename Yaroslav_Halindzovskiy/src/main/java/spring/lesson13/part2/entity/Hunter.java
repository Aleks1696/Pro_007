package spring.lesson13.part2.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.persistence.criteria.CriteriaBuilder;

public class Hunter implements HunterIntarface  {
    private String name;
    private Integer hp;
    /* В случае, если в контейнере будет подходящая реализация, то она будет добавлена */
    @Autowired
    @Qualifier("Tuzik")
    private Pet pet;

    public Hunter(String name, Integer hp) {
        this.name = name;
        this.hp = hp;

    }


    public String getName() {
        return name;
    }
    public Integer getHp() {
        return hp;
    }
    public Pet getPet() {
        return pet;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Hunter{");
        sb.append("name='").append(name).append('\'');
        sb.append(", hp=").append(hp);
        sb.append(", pet=").append(pet);
        sb.append('}');
        return sb.toString();
    }
}
