package hibernate.homework_with_IStore_part2.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

@Entity
@Table(name = "Store")
public class Store {

    @Id
    @Column(name = "Batch_number")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long batchNumber;

    @Column(name = "Receiving_Date")
    private GregorianCalendar receivingDate;

    @Column(name = "Laptop_at_this_batch")
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "batchNumber", targetEntity = Laptop.class)
    List<Laptop> laptopListFromBatch = new ArrayList<>();

    @Column(name = "Amount_at_store")
    private Integer amountAtStore;

    public Store() {
    }

    public Store(GregorianCalendar receivingDate) {
        this.receivingDate = receivingDate;
        this.amountAtStore = laptopListFromBatch.size();
    }

    public Long getBatchNumber() {
        return batchNumber;
    }

    public void setBatchNumber(Long batchNumber) {
        this.batchNumber = batchNumber;
    }

    public GregorianCalendar getReceivingDate() {
        return receivingDate;
    }

    public void setReceivingDate(GregorianCalendar receivingDate) {
        this.receivingDate = receivingDate;
    }

    public List<Laptop> getLaptopListFromBatch() {
        return laptopListFromBatch;
    }

    public void setLaptopListFromBatch(List<Laptop> laptopListFromBatch) {
        this.laptopListFromBatch = laptopListFromBatch;
    }

    public Integer getAmountAtStore() {
        return amountAtStore;
    }

    public void setAmountAtStore(Integer amountAtStore) {
        this.amountAtStore = amountAtStore;
    }
}
