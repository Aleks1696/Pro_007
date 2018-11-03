package hibernate.lesson10.entity;


import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "ORDERS")
public class Order {
    /*Для любой сущности Hibernate обязательное наличие,
     уникального идентификатора ID
     @Id - отмечает поле как идентификатора для Hibernate
     @Column возволяет создать имя столбца
     @GeneratedValue - позволяет задать стратегию заполнения поля (генерирует значения )

     */

    /* @Enumerated - позволяет нам задать тип в котором значение будет сохранено в БД
    * EnumType.ORDINAL
    * Enum.STRING - засиывает значение
    *
    * */


    @Id
    @Column (name = "ORDERS_ID ", nullable = false)
    @GeneratedValue (strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "NAME")
    private String name;

    @Column (name = "PRODUCT_QUALITY")
    @Enumerated(EnumType.STRING)
    private ProductQality qality;

    @Column(name = "AMOUND")
    private Integer amount;

    @Column (name = "PRICE")
    private Double price;

    @Temporal(TemporalType.DATE)
    @Column(name = "CREATION_DATE")
    private Date creationDate;


    public long getId() {
        return id;
    }

    public Order setId(long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Order setName(String name) {
        this.name = name;
        return this;
    }

    public ProductQality getQality() {
        return qality;
    }

    public Order setQality(ProductQality qality) {
        this.qality = qality;
        return this;
    }

    public Integer getAmount() {
        return amount;
    }

    public Order setAmount(Integer amount) {
        this.amount = amount;
        return this;
    }

    public Double getPrice() {
        return price;
    }

    public Order setPrice(Double price) {
        this.price = price;
        return this;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public Order setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
        return this;
    }

    public Order(String name, ProductQality qality, Integer amount, Double price, Date creationDate) {
        this.name = name;
        this.qality = qality;
        this.amount = amount;
        this.price = price;
        this.creationDate = creationDate;

    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Order{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", qality=").append(qality);
        sb.append(", amount=").append(amount);
        sb.append(", price=").append(price);
        sb.append(", creationDate=").append(creationDate);
        sb.append('}');
        return sb.toString();
    }
}

