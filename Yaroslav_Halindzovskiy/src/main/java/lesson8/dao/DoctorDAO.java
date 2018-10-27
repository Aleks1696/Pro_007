package lesson8.dao;

import lesson8.entity.Doctor;

import java.util.List;
/*
 * DAO (Data Access Object -  шаблон проектирования , озновное назначение - обработка записей в БД.
 *
 *
 * В состав шаблона DAO 5 основых методов
 *
 * CRUD - операции
 *
 *
 *  - Creat
 *  - Read
 *  - Update
 *  - Delete
 *
 *
 *  - findAll -  проверяет наличие  записи в табл БД
 *  и если они есть  возвращает их
 *   - getAll () -   проверяет наличие  записи в табл БД , а если их нет ,
 *   возращает throw new  IllegalException ()
 *
 *
 * */

public interface DoctorDAO {

    public void create (Doctor doctor);

    public Doctor read (Integer id);
    public void update (Doctor doctor);
    public void delete (Integer id );

    public List<Doctor> findAll();
}
