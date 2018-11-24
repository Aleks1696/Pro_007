package com.service.core.dao;

import com.service.core.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository
        extends JpaRepository<Student, Long> {

    Student findByIdEquals(Long id);
}
