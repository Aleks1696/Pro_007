package spring.homework13.entity;

public class Car {
    private String model;
    private Integer age;

    public Car(String model, Integer age) {
        this.model = model;
        this.age = age;
    }

    public Car() {

    }

    public String getModel() {
        return model;
    }

    public Car setModel(String model) {
        this.model = model;
        return this;
    }

    public Integer getAge() {
        return age;
    }

    public Car setAge(Integer age) {
        this.age = age;
        return this;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Car{");
        sb.append("model='").append(model).append('\'');
        sb.append(", age=").append(age);
        sb.append('}');
        return sb.toString();
    }
}
