package spring.lesson13.part1.entity;

public class Weapon {
    private String type;
    private Integer damage;
    private Integer weight;

    public String getType() {
        return type;
    }

    public Weapon setType(String type) {
        this.type = type;
        return this;
    }

    public Integer getDamage() {
        return damage;
    }

    public Weapon setDamage(Integer damage) {
        this.damage = damage;
        return this;
    }

    public Integer getWeight() {
        return weight;
    }

    public Weapon setWeight(Integer weight) {
        this.weight = weight;
        return this;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Weapon{");
        sb.append("type='").append(type).append('\'');
        sb.append(", damage=").append(damage);
        sb.append(", weight=").append(weight);
        sb.append('}');
        return sb.toString();
    }
}
