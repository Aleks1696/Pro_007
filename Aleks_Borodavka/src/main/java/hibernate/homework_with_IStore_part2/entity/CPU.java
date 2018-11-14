package hibernate.homework_with_IStore_part2.entity;

import hibernate.homework_with_IStore_part2.entity.types.CPUs;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "CPU_DAO")
public class CPU {

    @Id
    @Column(name = "CPU_Serial_number")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long cpuSerialNumber;

    @Column(name = "CPU_model")
    @Enumerated(EnumType.STRING)
    private CPUs cpuModel;

    @Column(name = "Clock_speed")
    private String cpuClockSpeed;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "cpu", targetEntity = Laptop.class)
    List<Laptop> laptopListWithCPU = new ArrayList<>();

    public CPU() {
    }

    public CPU(CPUs cpuModel, String cpuClockSpeed) {
        this.cpuModel = cpuModel;
        this.cpuClockSpeed = cpuClockSpeed;
    }

    public Long getCpuSerialNumber() {
        return cpuSerialNumber;
    }

    public void setCpuSerialNumber(Long cpuSerialNumber) {
        this.cpuSerialNumber = cpuSerialNumber;
    }

    public CPUs getCpuModel() {
        return cpuModel;
    }

    public void setCpuModel(CPUs cpuModel) {
        this.cpuModel = cpuModel;
    }

    public String getCpuClockSpeed() {
        return cpuClockSpeed;
    }

    public void setCpuClockSpeed(String cpuClockSpeed) {
        this.cpuClockSpeed = cpuClockSpeed;
    }

    public List<Laptop> getLaptopListWithCPU() {
        return laptopListWithCPU;
    }

    public void setLaptopListWithCPU(List<Laptop> laptopListWithCPU) {
        this.laptopListWithCPU = laptopListWithCPU;
    }
}
