package jdbs.lesson08.dao;

import jdbs.lesson08.entity.Doctor;

import java.util.List;

public interface DoctorDAO {
    /*
    DAO (Data Access Object) - шаблон проектирования,
    для обработок записей в БД
    В составе шаблона DAO 5 основных методов:
    CRUD:
        - create
        - reade
        - update
        - delete

        - findAll() - берет все записи и проверяет их (если таблица пустая
                    ничего не вернется иначе вернет все записи)
        - getAll() - проверяет наличие записей в таблице БД и если
                    их нет ко кидется эксепшеном throw new IllegalStateException()
     */
    public void create(Doctor doctor);
    public Doctor read(Integer id);
    public void update(Doctor doctor);
    public void delete(Integer id);

    public List<Doctor> findAll();

}
