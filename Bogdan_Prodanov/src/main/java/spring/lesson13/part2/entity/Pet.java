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

    public void setName(String name) {
        this.name = name;
    }

    public Integer getHp() {
        return hp;
    }

    public void setHp(Integer hp) {
        this.hp = hp;
    }

    public Integer getDamage() {
        return damage;
    }

    public void setDamage(Integer damage) {
        this.damage = damage;
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
