package spring.homework14.service;




import org.springframework.stereotype.Service;
import spring.homework14.entity.Laptop;

import java.util.Date;
import java.util.List;
@Service
public interface LaptopService {
    Long create(Laptop laptop);
    Laptop read(Long id);
    void update(Laptop laptop);
    void delete(Laptop laptop);
    List<Laptop> findAll();
    List<Laptop> findByVendor(String vendor);
    List<Laptop> findByPrice(Double price);
    List<Laptop> findByDate(Date date);
    List<Laptop> findByCpuFrequence(Double frequence);

}
