package spring.lesson13.part1.entity;

public class Human {
    private String name;
    private Integer age;
    private Integer hp;
    private Weapon weapon;



    public Human setWeapon(Weapon weapon) {
        this.weapon = weapon;
        return this;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Human{");
        sb.append("name='").append(name).append('\'');
        sb.append(", age=").append(age);
        sb.append(", hp=").append(hp);
        sb.append(", weapon=").append(weapon);
        sb.append('}');
        return sb.toString();
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public Integer getHp() {
        return hp;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public Human(String name, Integer age, Integer hp) {
        this.name = name;
        this.age = age;
        this.hp = hp;

    }
}
