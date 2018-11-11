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

    public Humanoid() { }
    public Humanoid(String model, Double price) {
        this.model = model;
        this.price = price;
    }
}
