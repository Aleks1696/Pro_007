package com.service.core.service;

import com.service.api.dto.StudentDTO;
import com.service.api.request.CreateStudentRequest;
import com.service.api.request.UpdateStudentRequest;
import com.service.core.dao.StudentRepository;
import com.service.core.domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;

@Service
public class StudentServiceImpl implements StudentsService {

    private StudentRepository studentRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Long create(CreateStudentRequest request) {
        Student student = new Student();
        student.setName(request.getName());
        student.setSurname(request.getSurname());
        student.setAge(request.getAge());
        student.setCreation(Calendar.getInstance().getTime());
        student.setLastUpdate(Calendar.getInstance().getTime());
        return studentRepository.saveAndFlush(student).getId();
    }

    public StudentDTO get(Long id) {
        Student student = studentRepository.findOne(id);
        if (student == null) {
            throw new IllegalStateException();
        }
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(student.getId());
        studentDTO.setName(student.getName());
        studentDTO.setSurname(student.getSurname());
        studentDTO.setAge(student.getAge());
        return studentDTO;
    }

    public void update(UpdateStudentRequest request) {
        Student student = studentRepository.findByIdEquals(request.getId());
        if (student == null) {
            throw new IllegalStateException();
        }
        student.setName(request.getName());
        student.setSurname(request.getSurname());
        student.setAge(request.getAge());
        student.setLastUpdate(Calendar.getInstance().getTime());
    }

    public void delete(Long id) {
        Student student = studentRepository.findByIdEquals(id);
        if (student != null) {
            studentRepository.delete(student);
        }
    }
}
