package com.service.service;

import com.service.api.dto.StudentDTO;
import com.service.api.request.CreateStudentRequest;
import com.service.api.request.UpdateStudentRequest;
import com.service.config.TestDBConfig;
import com.service.core.dao.StudentRepository;
import com.service.core.domain.Student;
import com.service.core.exception.StudentDataException;
import com.service.core.service.StudentsService;
import com.service.util.StudentUtil;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

/* Позволяем запускать тесты на этапе сборки проекта*/
@RunWith(SpringRunner.class)
/* Определяем тест - как тест БД */
@DataJpaTest
/* Автоконфигурация контекста Spring для БД*/
@DirtiesContext
/* Автоконфигурация Spring Boot*/
@EnableAutoConfiguration
/* Автоконфигурация тестовой БД*/
@AutoConfigureTestDatabase(
        replace = AutoConfigureTestDatabase.Replace.AUTO_CONFIGURED)
/* Местоположение сущностей*/
@EntityScan("com.service.core.domain")
/* Местоположение репозиториев */
@EnableJpaRepositories("com.service.core.dao")
/* Местоположение тестируемых сервисов*/
@ComponentScan(basePackages = {"com.service.core.service"})
/* Выполнение тестов в порядке алфавита по имени */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class StudentServiceTest {

    /* Подключение настроек доступа к БД*/
    @Configuration
    @Import(TestDBConfig.class)
    static class Configure {}

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private StudentsService studentsService;

    @Test
    public void testCreateStudentPositive() {
        CreateStudentRequest request = new CreateStudentRequest();
        request.setName("Ivan");
        request.setSurname("Popov");
        request.setAge(25);

        Long studentId = studentsService.create(request);

        Student result = studentRepository.findOne(studentId);

        Assert.assertNotNull(result);
        Assert.assertEquals(request.getName(), result.getName());
        Assert.assertEquals(request.getSurname(), result.getSurname());
        Assert.assertEquals(request.getAge(), result.getAge());
    }

    @Test
    public void testGetStudentPositive() {
        Student student = studentRepository.saveAndFlush(
                StudentUtil.createSingleStudentRecord());

        StudentDTO result = studentsService.get(student.getId());

        Assert.assertNotNull(result);
        Assert.assertEquals(student.getId(), result.getId());
        Assert.assertEquals(student.getName(), result.getName());
        Assert.assertEquals(student.getSurname(), result.getSurname());
        Assert.assertEquals(student.getAge(), result.getAge());
    }

    @Test(expected = StudentDataException.class)
    public void testGetStudentBadIdNegative() {
        studentsService.get(StudentUtil.BAD_STUDENT_ID);
    }

    @Test
    public void testUpdateStudentPositive() {
        Student student = studentRepository.saveAndFlush(
                StudentUtil.createSingleStudentRecord());

        UpdateStudentRequest request = new UpdateStudentRequest();
        request.setId(student.getId());
        request.setName("Magomet");
        request.setSurname(student.getSurname());
        request.setAge(31);
        studentsService.update(request);

        Student result = studentRepository.findOne(student.getId());

        Assert.assertEquals(student.getId(), result.getId());
        Assert.assertEquals(student.getName(), result.getName());
        Assert.assertEquals(student.getSurname(), result.getSurname());
        Assert.assertEquals(student.getAge(), result.getAge());
    }

    @Test(expected = StudentDataException.class)
    public void testUpdateStudentBadIdNegative() {
        UpdateStudentRequest request = new UpdateStudentRequest();
        request.setId(StudentUtil.BAD_STUDENT_ID);
        request.setName("Magomet");
        request.setSurname("Kadirov");
        request.setAge(31);
        studentsService.update(request);
    }

    @Test
    public void testDeleteStudentPositive() {
        Student student = studentRepository.saveAndFlush(
                StudentUtil.createSingleStudentRecord());

        studentsService.delete(student.getId());

        Assert.assertNull(studentRepository.findOne(student.getId()));
    }

    @Test(expected = StudentDataException.class)
    public void testDeleteStudentBadIdNegative() {
        studentsService.delete(StudentUtil.BAD_STUDENT_ID);
    }
}
