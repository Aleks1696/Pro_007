package spring.lesson13.part2.entity;

import org.springframework.beans.factory.annotation.Autowired;

public class Hunter {

    private String name;
    private Integer hp;
    @Autowired
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
