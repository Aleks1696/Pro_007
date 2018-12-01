package hibernate.homework11.entity.types;


import hibernate.homework11.entity.types.enums.CPUenum;

import javax.persistence.*;


@Entity
@Table(name = "CPU")

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
}
