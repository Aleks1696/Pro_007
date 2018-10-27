package jdbc.lesson08.dao;

import jdbc.lesson08.entity.Doctor;

import java.util.List;

/**
 * DAO (Data Access object - шаблон проэктирования,
 * основное назначение - обработка записей в Базе Данных
 *
 *В составе шаблона DAO входит 4 основных методов:
 * CRUD- операции
 * -------------------------
 * -Create
 * -Reade
 * -Update
 * -Delete
 * ---------------------------------------------------------------
 *
 * -findAll() - проверяет наличие записей в табл. БД
 *                                          и если они есть возвращает их,
 *                                          иначе ничего не делается
 *- getAll() - проверяет наличие записей в таблице БД
 *            и если их нет, то кидаются эксепшены
 *            throw new IllegalStateException
 *
 */
public interface DoctorDAO {
    public void create(Doctor doctor);
    public Doctor read(Integer id);
    public void update(Doctor doctor);
    public void delete(Integer id);
    public List<Doctor> findAll();

}
