package homework11.entity.types;

import homework11.entity.Laptop;
import homework11.entity.types.enums.MemoryTypes;

import javax.persistence.*;


@Entity
@Table(name = "memory")
public class Memory {

    @Id
    @Column(name = "memory_id", nullable = false)
    @SequenceGenerator(name = "memoryId", sequenceName = "seq_memory_id")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "memoryId")
    private Long id;

    @Column(name = "serial_number_memory", unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long serialNumberMenory;

    @Column(name = "type")
    private MemoryTypes memoryTypes;

    @Column(name = "frequency")
    private Double frequency;

    @OneToOne(fetch = FetchType.EAGER, mappedBy = "memory", targetEntity = Laptop.class)
    private Laptop laptop;

    public Memory(MemoryTypes memoryTypes, Double frequency) {
        this.memoryTypes = memoryTypes;
        this.frequency = frequency;
    }

    public Memory() {
    }

    public Long getId() {
        return id;
    }
    public Memory setId(Long id) {
        this.id = id;
        return this;
    }
    public Long getSerialNumberMenory() {
        return serialNumberMenory;
    }
    public Memory setSerialNumberMenory(Long serialNumberMenory) {
        this.serialNumberMenory = serialNumberMenory;
        return this;
    }
    public MemoryTypes getMemoryTypes() {
        return memoryTypes;
    }
    public Memory setMemoryTypes(MemoryTypes memoryTypes) {
        this.memoryTypes = memoryTypes;
        return this;
    }
    public Double getFrequency() {
        return frequency;
    }
    public Memory setFrequency(Double frequency) {
        this.frequency = frequency;
        return this;
    }
    public Laptop getLaptop() {
        return laptop;
    }
    public Memory setLaptop(Laptop laptop) {
        this.laptop = laptop;
        return this;
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Memory{");
        sb.append("id=").append(id);
        sb.append(", serialNumberMenory=").append(serialNumberMenory);
        sb.append(", memoryTypes=").append(memoryTypes);
        sb.append(", frequency=").append(frequency);
        sb.append(", laptop=").append(laptop);
        sb.append('}');
        return sb.toString();
    }
}
