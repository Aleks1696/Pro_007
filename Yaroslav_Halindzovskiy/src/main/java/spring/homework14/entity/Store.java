package spring.homework14.entity;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "store")
public class Store {

    @Id
    @Column(name = "store_id",nullable = false)
    @SequenceGenerator(name = "storeId",sequenceName = "seq_store_id")
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "storeId")
    private Long id;

@Column(name = "date")
    private Date date;
@Column(name = "qantity")
private Integer qantity;

@ManyToMany(fetch = FetchType.EAGER,targetEntity = Laptop.class)
    @JoinTable(name = "record_on_laptop",
            joinColumns = @JoinColumn(name = "store_ref_id",referencedColumnName = "store_id"),

    inverseJoinColumns = @JoinColumn(name = "laptop_ref_id",referencedColumnName = "laptop_id"))
    private List<Laptop> laptops = new ArrayList<>();

    public Store(Date date, Integer qantity, List<Laptop> laptops) {
        this.date = date;
        this.qantity = qantity;
        this.laptops = laptops;
    }

    public Store(Date date, Integer qantity) {
        this.date = date;
        this.qantity = qantity;
    }

    public Store() {
    }

    public Long getId() {
        return id;
    }

    public Store setId(Long id) {
        this.id = id;
        return this;
    }

    public Date getDate() {
        return date;
    }

    public Store setDate(Date date) {
        this.date = date;
        return this;
    }

    public Integer getQantity() {
        return qantity;
    }

    public Store setQantity(Integer qantity) {
        this.qantity = qantity;
        return this;
    }

    public List<Laptop> getLaptops() {
        return laptops;
    }

    public void setLaptops(List<Laptop> laptops) {
        this.laptops = laptops;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Store{");
        sb.append("id=").append(id);
        sb.append(", date=").append(date);
        sb.append(", qantity=").append(qantity);
        sb.append(", laptops=").append(laptops);
        sb.append('}');
        return sb.toString();
    }
}
