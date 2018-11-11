package spring.lesson13.task.annotations.entity;

public class Car {

    private String model;
    private String color;
    private Integer year;

    public Car(String model, String color, Integer year) {
        this.model = model;
        this.color = color;
        this.year = year;
    }

    public String getModel() {
        return model;
    }
    public String getColor() {
        return color;
    }
    public Integer getYear() {
        return year;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Car{");
        sb.append("model='").append(model).append('\'');
        sb.append(", color='").append(color).append('\'');
        sb.append(", year=").append(year);
        sb.append('}');
        return sb.toString();
    }
}
