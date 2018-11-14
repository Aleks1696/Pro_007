package spring.lesson13.part2.entity;

public class Pet {

    private String name;
    private Integer hp;
    private Integer damage;

    public Pet(String name, Integer hp, Integer damage) {
        this.name = name;
        this.hp = hp;
        this.damage = damage;
    }

    public String getName() {
        return name;
    }
    public Integer getHp() {
        return hp;
    }
    public Integer getDamage() {
        return damage;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Pet{");
        sb.append("name='").append(name).append('\'');
        sb.append(", hp=").append(hp);
        sb.append(", damage=").append(damage);
        sb.append('}');
        return sb.toString();
    }
}
