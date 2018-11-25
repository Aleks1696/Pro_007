package spring.homework2.entity;


import spring.homework2.entity.types.MemoryEnum;

import javax.persistence.*;

@Entity
@Table(name = "memory")
public class Memory {
    @Id
    @Column(name = "memory_id",nullable = false)
    @SequenceGenerator(name = "memoryId",sequenceName = "seq_memory_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "memory_type")
    private MemoryEnum type;

    @Column(name = "size")
    private Long size;

    @Column(name = "frequency")
    private Long frequency;
    @OneToOne(fetch = FetchType.EAGER,mappedBy = "memory",targetEntity = Notebook.class)

    private Notebook notebook;

    public Memory() {
    }

    public Memory(MemoryEnum type, Long size, Long frequency) {
        this.type = type;
        this.size = size;
        this.frequency = frequency;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public MemoryEnum getType() {
        return type;
    }

    public void setType(MemoryEnum type) {
        this.type = type;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public Long getFrequency() {
        return frequency;
    }

    public void setFrequency(Long frequency) {
        this.frequency = frequency;
    }

    public Notebook getNotebook() {
        return notebook;
    }

    public void setNotebook(Notebook notebook) {
        this.notebook = notebook;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Memory{");
        sb.append("id=").append(id);
        sb.append(", type=").append(type);
        sb.append(", size=").append(size);
        sb.append(", frequency=").append(frequency);
        sb.append(", notebook=").append(notebook);
        sb.append('}');
        return sb.toString();
    }
}
