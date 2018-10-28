package hibernate.lesson10.entity;

/* @Entity - отмечает класс как обьект для доступа
 *            будет возможность взаимодействовать с БД и ее записями
 *  @Table -  аннотация которая позволяет нам задать
 *            имя таблицы*/

import hibernate.lesson10.entity.types.ProductQuality;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "ORDERS")
public class Order {

    /*для любой сущности Hibernate обязательно наличие,
     * уникально идентификатора ID
     *
     * @Column - позволяет задать имя столбца*/

    @Id
    @Column(name = "ORDER ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="PRODUCT")
    private String product;
    /*
     * @Enumerated - позволяет нам задать тип в котором
      * значение будет сохранено в БД.
      * EnumType.ORDINAL - записывает индекс (рекомендуется к использованию)
      * EnumType.STRING - записывает значение*/
    @Column(name="PRODUCT QUALITY")
    @Enumerated(EnumType.STRING)
    private ProductQuality quality;

    @Column(name="AMOUNT")
    private Integer amount;

    @Column(name="PRICE")
    private Double price;

    @Temporal(TemporalType.DATE)
    @Column(name="DREATION DATA")
    private Date creation;


    public Order() {
    }

    public Order(String product, ProductQuality quality, Integer amount, Double price, Date creation) {
        this.product = product;
        this.quality = quality;
        this.amount = amount;
        this.price = price;
        this.creation = creation;
    }

    public Long getId() {
        return id;
    }

    public Order setId(Long id) {
        this.id = id;
        return this;
    }

    public String getProduct() {
        return product;
    }

    public Order setProduct(String product) {
        this.product = product;
        return this;
    }

    public ProductQuality getQuality() {
        return quality;
    }

    public Order setQuality(ProductQuality quality) {
        this.quality = quality;
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

    public Date getCreation() {
        return creation;
    }

    public Order setCreation(Date creation) {
        this.creation = creation;
        return this;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Order{");
        sb.append("id=").append(id);
        sb.append(", product='").append(product).append('\'');
        sb.append(", quality=").append(quality);
        sb.append(", amount=").append(amount);
        sb.append(", price=").append(price);
        sb.append(", creation=").append(creation);
        sb.append('}');
        return sb.toString();
    }
}
