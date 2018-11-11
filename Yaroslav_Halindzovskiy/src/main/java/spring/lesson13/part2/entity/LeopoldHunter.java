package spring.lesson13.part2.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class LeopoldHunter implements HunterIntarface {
    private String name;
    private Integer hp;
    /* В случае, если в контейнере будет подходящая реализация, то она будет добавлена */


    public LeopoldHunter(String name, Integer hp) {
        this.name = name;
        this.hp = hp;
    }

    @Autowired
    @Qualifier("Sharik")
    private Pet pet;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Integer getHp() {
        return hp;
    }

    @Override
    public Pet getPet() {
        return pet;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("LeopoldHunter{");
        sb.append("name='").append(name).append('\'');
        sb.append(", hp=").append(hp);
        sb.append(", pet=").append(pet);
        sb.append('}');
        return sb.toString();
    }
}
