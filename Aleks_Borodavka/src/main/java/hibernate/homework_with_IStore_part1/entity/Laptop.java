package hibernate.homework_with_IStore_part1.entity;

import hibernate.homework_with_IStore_part1.entity.types.Manufacturers;
import javax.persistence.*;
import java.util.GregorianCalendar;


@Entity
@Table(name = "IStore")
public class Laptop {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "Serial_number")
    private Integer serialNumber;

    @Column(name = "Manufacturer")
    @Enumerated(EnumType.STRING)
    private Manufacturers manufacturer;

    @Column(name = "Model")
    private String model;

    @Column(name = "Manufacture_Date")
    private GregorianCalendar manufactureDate;

    @Column(name = "Price")
    private Double price;

    public Laptop() {
    }

    public Laptop(Integer serialNumber, Manufacturers manufacturer, String model,
                  GregorianCalendar manufactureDate, Double price) {
        this.serialNumber = serialNumber;
        this.manufacturer = manufacturer;
        this.model = model;
        this.manufactureDate = manufactureDate;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(Integer serialNumber) {
        this.serialNumber = serialNumber;
    }

    public Manufacturers getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturers manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public GregorianCalendar getManufactureDate() {
        return manufactureDate;
    }

    public void setManufactureDate(GregorianCalendar manufactureDate) {
        this.manufactureDate = manufactureDate;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Laptop{");
        sb.append("id=").append(id);
        sb.append(", serialNumber='").append(serialNumber).append('\'');
        sb.append(", manufacturer=").append(manufacturer);
        sb.append(", model='").append(model).append('\'');
        sb.append(", manufactureDate=").append(manufactureDate);
        sb.append(", price=").append(price);
        sb.append('}');
        return sb.toString();
    }
}



