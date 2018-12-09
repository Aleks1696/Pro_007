package spring.lesson22.entity;


import javax.persistence.*;

@Entity
@Table(name = "cars")
public class Car {

    @Id
    @Column(name = "car_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private String model;
    @Column
    private String color;
    @Column
    private Integer year;

    public Car() {}
    public Car(String model, String color, Integer year) {
        this.model = model;
        this.color = color;
        this.year = year;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public Integer getYear() {
        return year;
    }
    public void setYear(Integer year) {
        this.year = year;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Car{");
        sb.append("id=").append(id);
        sb.append(", model='").append(model).append('\'');
        sb.append(", color='").append(color).append('\'');
        sb.append(", year=").append(year);
        sb.append('}');
        return sb.toString();
    }
}
