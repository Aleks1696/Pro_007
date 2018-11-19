package com.service.core.service;

import com.service.api.dto.StudentDTO;
import com.service.api.request.CreateStudentRequest;
import com.service.api.request.UpdateStudentRequest;
import com.service.core.domain.Student;

public interface StudentsService {
    Long create (CreateStudentRequest request);
    StudentDTO get (Long id);
    void  update(UpdateStudentRequest request);
    void delete (Long id);
}
