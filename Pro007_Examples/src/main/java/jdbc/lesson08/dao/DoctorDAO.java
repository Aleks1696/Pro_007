package jdbc.lesson08.dao;

import jdbc.lesson08.entity.Doctor;

import javax.print.Doc;
import java.util.List;

/**
 * DAO (Data Access Object) - шаблон проектирования,
 * основное назначение - обработка записей в БД
 *
 * В состав шаблона DAO входит 4 основных методов:
 *
 * CRUD - операции:
 *
 *  - Create
 *  - Reade
 *  - Update
 *  - Delete
 *
 *  - findAll() - проверяет наличие записей в таблице БД
 *              и если они есть возвращает их,
 *              иначе ничего не делается
 *  - getAll() -    проверяет наличие записей в таблице БД
 *      *           и если их нет то кидается эксепшен
 *                  throw new IllegalStateException()
 * */
public interface DoctorDAO {

    public void create(Doctor doctor);
    public Doctor read(Integer id);
    public void update(Doctor doctor);
    public void delete(Integer id);

    public List<Doctor> findAll();

}
