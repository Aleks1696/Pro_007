package hibernate.lesson10.entity;


import hibernate.lesson10.entity.types.ProductQuality;

import javax.persistence.*;
import java.util.Date;

/* @Entity - отмечает класс как объект с помощью которого
 *            будет возможность взаимодействовать с БД и ее
 *            записями
 *  @Table  - аннотация которая позволяет нам задать
 *  имя таблицы */

@Entity
@Table(name = "ORDERS")
public class Order {

    /* Для любой сущности Hibernate обязательно наличие,
     *  уникального иденетефикатора ID
     *
     *  @Id     - отмечает поле как идентефикатор для Hibernate
     *  @Column - позволяет задать имя столбца
     *  @GeneratedValue - позволяет задать стратегию заполнения
     *                    поля (генерируется значение)*/

    @Id
    @Column(name = "ORDER_ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "PRODUCT")
    private String product;

    /* @Enumerated - позволяет нам задать тип в котором
     *                значение будет сохранено в БД
     *  EnumType.ORDINAL - записывает индекс (рекомендуется к исмользованию)
     *  EnumType.STRING  - записывает значения */

    @Column(name = "PRODUCT_QUALITY")
    @Enumerated(EnumType.STRING)
    private ProductQuality quality;

    @Column(name = "AMOUNT")
    private Integer amount;

    @Column(name = "PRICE")
    private Double price;

    @Temporal(TemporalType.DATE)
    @Column(name = "CREATION_DATE")
    private Date creationDate;

    public Order() {}
    public Order(String product, ProductQuality quality, Integer amount, Double price, Date creationDate) {
        this.product = product;
        this.quality = quality;
        this.amount = amount;
        this.price = price;
        this.creationDate = creationDate;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getProduct() {
        return product;
    }
    public void setProduct(String product) {
        this.product = product;
    }
    public ProductQuality getQuality() {
        return quality;
    }
    public void setQuality(ProductQuality quality) {
        this.quality = quality;
    }
    public Integer getAmount() {
        return amount;
    }
    public void setAmount(Integer amount) {
        this.amount = amount;
    }
    public Double getPrice() {
        return price;
    }
    public void setPrice(Double price) {
        this.price = price;
    }
    public Date getCreationDate() {
        return creationDate;
    }
    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Order{");
        sb.append("id=").append(id);
        sb.append(", product='").append(product).append('\'');
        sb.append(", quality=").append(quality);
        sb.append(", amount=").append(amount);
        sb.append(", price=").append(price);
        sb.append(", creationDate=").append(creationDate);
        sb.append('}');
        return sb.toString();
    }
}
