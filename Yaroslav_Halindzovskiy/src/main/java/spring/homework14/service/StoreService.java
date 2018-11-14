package spring.homework14.service;


import spring.homework14.entity.Laptop;
import spring.homework14.entity.Store;

import java.util.Date;
import java.util.List;

public interface StoreService {
    Store create();
    Store createParty(Date date, Integer qantity, List<Laptop> laptops);
    Store read(Long id);
    void update(Store store);
    void delete(Store store);
    List<Store> findAll() ;
    void sell(Long id);
     List findByNumberOfParty(Long id);
    List findLapptopByDate(Date date);

  /*  Создание новой партии ноутбуков
   -  Продажа ноутбука со склада (желательно добавить
      проверку наличия ноутбука)
   -  Поиск ноутбука по номеру партии
   -  Поиск ноутбука по дате поступления*/

}
