package com.service.core.endpoint;

import com.service.api.dto.StudentDTO;
import com.service.api.endpoint.StudentsEndpoint;
import com.service.api.request.CreateStudentRequest;
import com.service.api.request.UpdateStudentRequest;
import com.service.api.response.GeneralResponse;
import com.service.core.service.StudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentsRestEndpoint implements StudentsEndpoint {

    private StudentsService studentsService;

    @Autowired
    public StudentsRestEndpoint(StudentsService studentsService) {
        this.studentsService = studentsService;
    }

    public GeneralResponse<Long> createStudent(@RequestBody CreateStudentRequest request) {
        return new GeneralResponse<Long>(
                "200", studentsService.create(request));
    }

    public GeneralResponse<StudentDTO> getStudentById(@RequestParam("id") Long id) {
        return new GeneralResponse<StudentDTO>("200", studentsService.get(id));
    }

    public GeneralResponse<Void> updateStudent(@RequestBody UpdateStudentRequest request) {
        studentsService.update(request);
        return new GeneralResponse<Void>("200", null);
    }

    public GeneralResponse<Void> deleteStudent(@RequestParam("id") Long id) {
        studentsService.delete(id);
        return new GeneralResponse<Void>("200", null);
    }
}