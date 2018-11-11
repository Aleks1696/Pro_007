package spring.lesson13.part2.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Hunter implements Hunterinterface {
    private String name;
    private Integer hp;
    /* @Autowired - позволяет нам обратится к контейнеру Spring IoC,и в случае если в контейнере будет
      * подходящая реализация,то она будет добавлена,то она будет добавлена в класс */
    @Autowired
    @Qualifier("Sharik")
    private Pet pet;

    public String getName() {
        return name;
    }

    public Integer getHp() {
        return hp;
    }

    public Pet getPet() {
        return pet;
    }

    public Hunter(String name, Integer hp) {
        this.name = name;
        this.hp = hp;

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
