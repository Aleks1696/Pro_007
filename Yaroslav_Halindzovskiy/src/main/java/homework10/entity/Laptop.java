package homework10.entity;

import homework10.entity.types.Brand;
import homework10.entity.types.CPU;
import homework10.entity.types.VideoCard;

import javax.persistence.*;


@Entity
@Table(name = "SHOP")

public class Laptop {

    @Id
    @Column(name = "LAPTOP_ID",nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "BRAND")
    @Enumerated(EnumType.STRING)
    private Brand brand;
    @Column(name = "PRICE")
    private double price;
    @Column(name = "CPU")
    @Enumerated(EnumType.STRING)
    private CPU cpu;
    @Column(name = "VIDEOCARD")
    @Enumerated(EnumType.STRING)
    private VideoCard videoCard;
    @Column(name = "HARD")
    private int hardDrive;

    public Long getId() {
        return id;
    }

    public Laptop setId(Long id) {
        this.id = id;
        return this;
    }

    public Laptop(String name, Brand brand, double price, CPU cpu, VideoCard videoCard, int hardDrive) {
        this.name = name;
        this.brand = brand;
        this.price = price;
        this.cpu = cpu;
        this.videoCard = videoCard;
        this.hardDrive = hardDrive;
    }

    public Laptop() {
    }

    public String getName() {
        return name;
    }

    public Laptop setName(String name) {
        this.name = name;
        return this;
    }

    public Brand getBrand() {
        return brand;
    }

    public Laptop setBrand(Brand brand) {
        this.brand = brand;
        return this;
    }

    public double getPrice() {
        return price;
    }

    public Laptop setPrice(double price) {
        this.price = price;
        return this;
    }

    public CPU getCpu() {
        return cpu;
    }

    public Laptop setCpu(CPU cpu) {
        this.cpu = cpu;
        return this;
    }

    public VideoCard getVideoCard() {
        return videoCard;
    }

    public Laptop setVideoCard(VideoCard videoCard) {
        this.videoCard = videoCard;
        return this;
    }

    public int getHardDrive() {
        return hardDrive;
    }

    public Laptop setHardDrive(int hardDrive) {
        this.hardDrive = hardDrive;
        return this;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Laptop{");
        sb.append("name='").append(name).append('\'');
        sb.append(", brand=").append(brand);
        sb.append(", price=").append(price);
        sb.append(", cpu=").append(cpu);
        sb.append(", videoCard=").append(videoCard);
        sb.append(", hardDrive=").append(hardDrive);
        sb.append('}');
        return sb.toString();
    }
}
