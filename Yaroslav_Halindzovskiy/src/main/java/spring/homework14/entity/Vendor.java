package spring.homework14.entity;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "vendor")
public class Vendor {
    @Id
    @Column(name = "vendor_id",nullable = false)
    @SequenceGenerator(name = "vendorId", sequenceName = "seq_vendor_id")
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "vendorId")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @OneToMany(fetch = FetchType.EAGER,mappedBy = "vendor",targetEntity = Laptop.class)
    private List<Laptop> laptops = new ArrayList<>();


    public Vendor() {
    }

    public Vendor(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public Vendor setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Vendor setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Vendor setDescription(String description) {
        this.description = description;
        return this;
    }

    public List<Laptop> getLaptops() {
        return laptops;
    }

    public Vendor setLaptops(List<Laptop> laptops) {
        this.laptops = laptops;
        return this;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Vendor{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", description='").append(description).append('\'');
        sb.append(", laptops=").append(laptops);
        sb.append('}');
        return sb.toString();
    }
}
