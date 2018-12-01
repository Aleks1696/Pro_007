package spring.homework2.entity;


import javax.persistence.*;

@Entity
@Table(name = "notebooks")
public class Notebook {

    @Id
    @Column(name = "notebook_id", nullable = false)
    @SequenceGenerator(name = "bookId", sequenceName = "seq_notebook_id")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "bookId")
    private Long id;


    @Column(name = "CPU")
    private CPU cpu;

    @Column(name = "Memory")
    private Memory memory;


    @Column(name = "Price")
    private Integer price;

    @Column(name = "year")
    private Integer year;

@OneToOne(fetch = FetchType.EAGER, targetEntity = CPU.class)
    @JoinColumn(name = "cpu_id",referencedColumnName = "cpu_id")
    private CPU cpu1;
//
//    @OneToOne(fetch = FetchType.EAGER, targetEntity = Memory.class)
//    @JoinColumn(name = "memory_id", referencedColumnName = "memory_id")
////    private Memory memory;

}
