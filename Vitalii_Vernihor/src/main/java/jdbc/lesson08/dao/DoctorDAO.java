package jdbc.lesson08.dao;

import jdbc.lesson08.entity.Doctor;

import java.util.List;

public interface DoctorDAO {

    //DAO (Data Access Object) - шаблон проектирования, основное назначение которого обработка записей в БД
    // В состав шаблона  DAO входят 4 основные метода
    // 1 - Create
    // 2 - Read
    // 3 - Update
    // 4 - Deleate
    //
    // findAll() - проверяет наличие записей в таблиц бд и если они есть возвращает их, иначе - ничего не делает
    // getAll() - проверяет наличие записей в таблиц бд и если их нет то кидается exeption throw new IllegalStateException

    public void create(Doctor doctor);
    public Doctor read(Integer id);
    public void update(Doctor doctor);
    public void deleate(Integer id);

    public List<Doctor> findAll();



}
