package spring.lesson13.part2.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class LeopoldHunter implements Hunterinterface {
    private String name;
    private Integer hp;

    @Autowired
    @Qualifier("Sharik")
    private Pet pet;

    public LeopoldHunter(String name, Integer hp) {
        this.name = name;
        this.hp = hp;

    }
    @Override
    public String getName() {
        return null;
    }

    @Override
    public Integer getHp() {
        return null;
    }

    @Override
    public Pet getPet() {
        return null;
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
