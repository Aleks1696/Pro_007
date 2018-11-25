package spring.homework2.entity;

import spring.homework2.entity.types.CPUenum;

import javax.persistence.*;

@Entity
@Table(name = "cpu")
public class CPU {

    @Id
    @Column(name = "cpu_id",nullable = false)
    @SequenceGenerator(name = "cpuId",sequenceName = "seq_cpu_id")
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "cpuId")
    private Long id;

    @Column(name = "Name")
    private CPUenum nameCPU;

    @Column(name = "frequency")
    private Double frequency;

@OneToOne(fetch= FetchType.EAGER,mappedBy = "cpu",targetEntity = Notebook.class)
    private Notebook notebook;

    public CPU(CPUenum nameCPU, Double frequency) {
        this.nameCPU = nameCPU;
        this.frequency = frequency;
    }

    public CPU() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CPUenum getNameCPU() {
        return nameCPU;
    }

    public void setNameCPU(CPUenum nameCPU) {
        this.nameCPU = nameCPU;
    }

    public Double getFrequency() {
        return frequency;
    }

    public void setFrequency(Double frequency) {
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
        final StringBuilder sb = new StringBuilder("CPU{");
        sb.append("id=").append(id);
        sb.append(", nameCPU=").append(nameCPU);
        sb.append(", frequency=").append(frequency);
        sb.append(", notebook=").append(notebook);
        sb.append('}');
        return sb.toString();
    }
}
