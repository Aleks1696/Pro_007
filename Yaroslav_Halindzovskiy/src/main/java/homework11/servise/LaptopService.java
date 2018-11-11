package homework11.servise;

import homework11.entity.Laptop;
import homework11.entity.types.CPU;
import homework11.entity.types.Memory;
import homework11.entity.types.Vendor;

import java.util.Date;
import java.util.List;

public interface LaptopService {
    Laptop create (Double price, Date date, CPU cpu, Memory memory, Vendor vendor);
    Laptop read (Long id);
    void update(Laptop laptop);
    void delete (Laptop laptop);
    List<Laptop> findAll();
    List<Laptop> findByVendor(String vendor);
    List<Laptop> findByPrice(Double price);
    List<Laptop> findByDate(Date date);
    List<Laptop> findByCpuFrequence(Double frequence);

}
