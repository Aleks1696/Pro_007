package spring.homework14.entity;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "laptop")
public class Laptop {

    @Id
    @Column(name = "laptop_id", nullable = false)
    @SequenceGenerator(name = "bookId", sequenceName = "seq_laptop_id")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "bookId")
    private Long id;

    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long serialNumber;

    @Column(name = "price")
    private Double price;

    @Column(name = "date")
    private Date date;

    @OneToOne(fetch = FetchType.EAGER, targetEntity = CPU.class)
    @JoinColumn(name = "cpu_id", referencedColumnName = "cpu_id")
   private CPU cpu;



    @OneToOne(fetch = FetchType.EAGER, targetEntity = Memory.class)
    @JoinColumn(name = "memory_id", referencedColumnName = "memory_id")
  private Memory memory;

    /*
    *
    @ManyToOne(fetch = FetchType.EAGER,targetEntity = Course.class)
    @JoinColumn(name = "course_id", referencedColumnName = "course_id",nullable = false)
    private Course course;
    */

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Vendor.class)
    @JoinColumn/*(name = "vendor_id", referencedColumnName = "vendor_id",nullable = false)*/
    private Vendor vendor;


    @ManyToMany(mappedBy = "laptops", targetEntity = Store.class)
    private List<Store> stores = new ArrayList<>();

    public Laptop() {
    }

    public Laptop(Double price, Date date, CPU cpu, Memory memory, Vendor vendor) {
        this.price = price;
        this.date = date;
        this.cpu = cpu;
        this.memory = memory;
        this.vendor = vendor;
    }

    public Long getId() {
        return id;
    }

    public Laptop setId(Long id) {
        this.id = id;
        return this;
    }

    public Long getSerialNumber() {
        return serialNumber;
    }

    public Laptop setSerialNumber(Long serialNumber) {
        this.serialNumber = serialNumber;
        return this;
    }

    public Double getPrice() {
        return price;
    }

    public Laptop setPrice(Double price) {
        this.price = price;
        return this;
    }

    public Date getDate() {
        return date;
    }

    public Laptop setDate(Date date) {
        this.date = date;
        return this;
    }

    public CPU getCpu() {
        return cpu;
    }

    public Laptop setCpu(CPU cpu) {
        this.cpu = cpu;
        return this;
    }

    public Memory getMemory() {
        return memory;
    }

    public Laptop setMemory(Memory memory) {
        this.memory = memory;
        return this;
    }

    public Vendor getVendor() {
        return vendor;
    }

    public Laptop setVendor(Vendor vendor) {
        this.vendor = vendor;
        return this;
    }

    public List<Store> getStores() {
        return stores;
    }

    public Laptop setStores(List<Store> stores) {
        this.stores = stores;
        return this;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Laptop{");
        sb.append("id=").append(id);
        sb.append(", serialNumber=").append(serialNumber);
        sb.append(", price=").append(price);
        sb.append(", date=").append(date);
        sb.append(", cpu=").append(cpu);
        sb.append(", memory=").append(memory);
        sb.append(", vendor=").append(vendor);
        sb.append(", stores=").append(stores);
        sb.append('}');
        return sb.toString();
    }
}
