package hibernate.homework_with_IStore_part2.entity;

import javax.persistence.*;
import java.util.GregorianCalendar;

@Entity
@Table(name = "Laptops")
public class Laptop {

    @Id
    @Column(name = "Serial_number")
    @SequenceGenerator(name = "Serial_number", sequenceName = "Serial_number", initialValue = 20180000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Serial_number")
    private Long serialNumber;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = CPU.class)
    @JoinColumn(name = "CPU_Serial_number", referencedColumnName = "CPU_Serial_number", nullable = false)
    private CPU cpu;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = RAM.class)
    @JoinColumn(name = "RAM_Serial_number", referencedColumnName = "RAM_Serial_number", nullable = false)
    private RAM ram;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Manufacturer.class)
    @JoinColumn(name = "Manufacturer_ID", referencedColumnName = "Manufacturer_ID", nullable = false)
    private Manufacturer manufacturer;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Store.class)
    @JoinColumn(name = "Batch_number", referencedColumnName = "Batch_number", nullable = false)
    private Store batchNumber;

    @Column(name = "Price")
    private Double price;

    @Column(name = "Manufacture_Date")
    private GregorianCalendar manufactureDate;

    public Laptop() {
    }

    public Laptop(CPU cpu, RAM ram, Manufacturer manufacturer, Double price, GregorianCalendar manufactureDate,
                  Store batchNumber) {
        this.cpu = cpu;
        this.ram = ram;
        this.manufacturer = manufacturer;
        this.price = price;
        this.manufactureDate = manufactureDate;
        this.batchNumber = batchNumber;
    }

    public Long getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(Long serialNumber) {
        this.serialNumber = serialNumber;
    }

    public CPU getCpu() {
        return cpu;
    }

    public void setCpu(CPU cpu) {
        this.cpu = cpu;
    }

    public RAM getRam() {
        return ram;
    }

    public void setRam(RAM ram) {
        this.ram = ram;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    public Store getBatchNumber() {
        return batchNumber;
    }

    public void setBatchNumber(Store batchNumber) {
        this.batchNumber = batchNumber;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public GregorianCalendar getManufactureDate() {
        return manufactureDate;
    }

    public void setManufactureDate(GregorianCalendar manufactureDate) {
        this.manufactureDate = manufactureDate;
    }

}
