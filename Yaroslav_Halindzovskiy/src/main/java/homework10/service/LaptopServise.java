package homework10.service;

import homework10.entity.Laptop;
import homework10.entity.types.Brand;
import homework10.entity.types.CPU;
import homework10.entity.types.VideoCard;

import java.util.List;

public interface LaptopServise {

Laptop create (String name, Brand brand, double price, CPU cpu, VideoCard videoCard, int hardDrive);
Laptop read (Long id);
void update(Laptop laptop);
void delete (Laptop laptop);
List<Laptop> findAll();



}
