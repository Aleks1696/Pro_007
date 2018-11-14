package spring.lesson13.part2.entity;

public class Pet {
    private String name;
    private Integer hp;
    private Integer damage;

    public Pet(String name, int hp, int damage) {
        this.name = name;
        this.hp = hp;
        this.damage = damage;
    }

    public String getName() {
        return name;
    }

    public Pet setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getHp() {
        return hp;
    }

    public Pet setHp(Integer hp) {
        this.hp = hp;
        return this;
    }

    public Integer getDamage() {
        return damage;
    }

    public Pet setDamage(Integer damage) {
        this.damage = damage;
        return this;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Pet{");
        sb.append("name='").append(name).append('\'');
        sb.append(", hp='").append(hp).append('\'');
        sb.append(", damage='").append(damage).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
