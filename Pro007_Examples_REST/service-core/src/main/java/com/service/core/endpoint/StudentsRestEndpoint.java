package com.service.core.endpoint;

import com.service.api.dto.StudentDTO;
import com.service.api.endpoint.StudentsEndpoint;
import com.service.api.request.CreateStudentRequest;
import com.service.api.request.UpdateStudentRequest;
import com.service.api.response.GeneralResponse;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentsRestEndpoint implements StudentsEndpoint {

    public GeneralResponse<Long> createStudent(@RequestBody CreateStudentRequest request) {
        return null;
    }

    public GeneralResponse<StudentDTO> getStudentById(@RequestParam("id") Long id) {
        return null;
    }

    public GeneralResponse<Void> updateStudent(@RequestBody UpdateStudentRequest request) {
        return null;
    }

    public GeneralResponse<Void> deleteStudent(@RequestParam("id") Long id) {
        return null;
    }
}