package homework11.entity.types;



import homework11.entity.Laptop;
import homework11.entity.types.enums.CPUenum;

import javax.persistence.*;

@Entity
@Table(name = "cpu")
public class CPU {
    @Id
    @Column(name = "cpu_id",nullable = false)
    @SequenceGenerator(name = "cpuId", sequenceName = "seq_cpu_id")
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "cpuId")
    private Long id;

    @Column(name = "serial_number_cpu",unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long serialNumberCpu;

    @Column (name = "brand_CPU")
    private CPUenum brandCPU;

    @Column(name = "frequency")
    private Double frequence;

    @OneToOne(fetch = FetchType.EAGER,mappedBy = "cpu",targetEntity = Laptop.class)
    private Laptop laptop;

    public CPU(CPUenum brandCPU, Double frequence) {
        this.brandCPU = brandCPU;
        this.frequence = frequence;
    }

    public CPU() {
    }

    public Long getId() {
        return id;
    }

    public CPU setId(Long id) {
        this.id = id;
        return this;
    }

    public Long getSerialNumberCpu() {
        return serialNumberCpu;
    }

    public CPU setSerialNumberCpu(Long serialNumberCpu) {
        this.serialNumberCpu = serialNumberCpu;
        return this;
    }

    public CPUenum getBrandCPU() {
        return brandCPU;
    }

    public CPU setBrandCPU(CPUenum brandCPU) {
        this.brandCPU = brandCPU;
        return this;
    }

    public Double getFrequence() {
        return frequence;
    }

    public CPU setFrequence(Double frequence) {
        this.frequence = frequence;
        return this;
    }

    public Laptop getLaptop() {
        return laptop;
    }

    public CPU setLaptop(Laptop laptop) {
        this.laptop = laptop;
        return this;
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CPU{");
        sb.append("id=").append(id);
        sb.append(", serialNumberCpu=").append(serialNumberCpu);
        sb.append(", brandCPU=").append(brandCPU);
        sb.append(", frequence=").append(frequence);
        sb.append(", laptop=").append(laptop);
        sb.append('}');
        return sb.toString();
    }
}
