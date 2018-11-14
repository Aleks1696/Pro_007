package hibernate.homework_with_IStore_part2.entity;

import hibernate.homework_with_IStore_part1.entity.types.Manufacturers;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Manufacturer")
public class Manufacturer {

    @Id
    @Column(name = "Manufacturer_ID")
    @Enumerated(EnumType.STRING)
    private Manufacturers manufacturerName;

    @Column(name = "Description")
    private String manufacturerDescription;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "manufacturer", targetEntity = Laptop.class)
    List<Laptop> laptopListByManufacturer = new ArrayList<>();

    public Manufacturer() {
    }

    public Manufacturer(Manufacturers manufacturerName, String manufacturerDescription) {
        this.manufacturerName = manufacturerName;
        this.manufacturerDescription = manufacturerDescription;
    }


    public Manufacturers getManufacturerName() {
        return manufacturerName;
    }

    public void setManufacturerName(Manufacturers manufacturerName) {
        this.manufacturerName = manufacturerName;
    }

    public String getManufacturerDescription() {
        return manufacturerDescription;
    }

    public void setManufacturerDescription(String manufacturerDescription) {
        this.manufacturerDescription = manufacturerDescription;
    }

    public List<Laptop> getLaptopListByManufacturer() {
        return laptopListByManufacturer;
    }

    public void setLaptopListByManufacturer(List<Laptop> laptopListByManufacturer) {
        this.laptopListByManufacturer = laptopListByManufacturer;
    }
}
