package homework11.servise;

import homework11.entity.Laptop;
import homework11.entity.Store;

import java.util.Date;
import java.util.List;

public interface StoreService {
    Store create (Date date, Integer qantity, List<Laptop> laptops);
    Store read (Long id);
    void update(Store store);
    void delete (Store store);
    List<Store> findAll () ;
    void sell(Long id);
     List findByNumberOfParty(Long id);
    List findLapptopByDate (Date date);

  /*  Создание новой партии ноутбуков
   -  Продажа ноутбука со склада (желательно добавить
      проверку наличия ноутбука)
   -  Поиск ноутбука по номеру партии
   -  Поиск ноутбука по дате поступления*/

}
