package hibernate.homework_with_IStore_part2.entity;

import hibernate.homework_with_IStore_part2.entity.types.RAM_Type;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "RAM")
public class RAM {

    @Id
    @Column(name = "RAM_Serial_number")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ramSerialNumber;

    @Column(name = "RAM_Type")
    @Enumerated(EnumType.STRING)
    private RAM_Type ramType;

    @Column(name = "RAM_Amount")
    private Integer ramAmount;

    @Column(name = "RAM_Frequency")
    private Integer ramFrequency;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "ram", targetEntity = Laptop.class)
    List<Laptop> laptopListWithRAM = new ArrayList<>();

    public RAM(){}

    public RAM(RAM_Type ramType, Integer ramAmount, Integer ramFrequency) {
        this.ramType = ramType;
        this.ramAmount = ramAmount;
        this.ramFrequency = ramFrequency;
    }

    public Long getRamSerialNumber() {
        return ramSerialNumber;
    }

    public void setRamSerialNumber(Long ramSerialNumber) {
        this.ramSerialNumber = ramSerialNumber;
    }

    public RAM_Type getRamType() {
        return ramType;
    }

    public void setRamType(RAM_Type ramType) {
        this.ramType = ramType;
    }

    public Integer getRamAmount() {
        return ramAmount;
    }

    public void setRamAmount(Integer ramAmount) {
        this.ramAmount = ramAmount;
    }

    public Integer getRamFrequency() {
        return ramFrequency;
    }

    public void setRamFrequency(Integer ramFrequency) {
        this.ramFrequency = ramFrequency;
    }

    public List<Laptop> getLaptopListWithRAM() {
        return laptopListWithRAM;
    }

    public void setLaptopListWithRAM(List<Laptop> laptopListWithRAM) {
        this.laptopListWithRAM = laptopListWithRAM;
    }
}
