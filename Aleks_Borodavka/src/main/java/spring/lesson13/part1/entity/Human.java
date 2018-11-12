package spring.lesson13.part1.entity;

public class Human {

    private String name;
    private String age;
    private String hp;
    private Weapon weapon;

    public Human(String name, String age, String hp) {
        this.name = name;
        this.age = age;
        this.hp = hp;
    }

    public String getName() {
        return name;
    }

    public String getAge() {
        return age;
    }

    public String getHp() {
        return hp;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Human{");
        sb.append("name='").append(name).append('\'');
        sb.append(", age='").append(age).append('\'');
        sb.append(", hp='").append(hp).append('\'');
        sb.append(", weapon=").append(weapon);
        sb.append('}');
        return sb.toString();
    }
}
