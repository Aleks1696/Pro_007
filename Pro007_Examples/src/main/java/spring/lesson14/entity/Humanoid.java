package spring.lesson14.entity;

import javax.persistence.*;

@Entity
@Table(name = "humanoids")
public class Humanoid {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String model;

    @Column
    private Double price;

    /* POJO - простой Java объект
    * - Наличие ключевого поля ID (Long)
    * - Коструктор по умолчанию (описывать явно
    *   не обязательно если не использовать другие
    *   конструкторы)
    * - Getters/Setters  */
    public Humanoid() {}
    public Humanoid(String model, Double price) {
        this.model = model;
        this.price = price;
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
    public Double getPrice() {
        return price;
    }
    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Humanoid{");
        sb.append("id=").append(id);
        sb.append(", model='").append(model).append('\'');
        sb.append(", price=").append(price);
        sb.append('}');
        return sb.toString();
    }
}
