package com.service.api.endpoint;

import com.service.api.dto.StudentDTO;
import com.service.api.request.CreateStudentRequest;
import com.service.api.request.UpdateStudentRequest;
import com.service.api.response.GeneralResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Info;
import io.swagger.annotations.SwaggerDefinition;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@SwaggerDefinition(
        info = @Info(description = "REST API", version = "1.0.0", title = "REST API"),
        produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
        schemes = SwaggerDefinition.Scheme.HTTPS
)
@Api(tags = "Students Rest Endpoint")
@RequestMapping("api/students")
public interface StudentsEndpoint {

    @ApiOperation(value = "Creating students account")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    GeneralResponse<Long> createStudent(CreateStudentRequest request);

    @ApiOperation(value = "Getting student account by ID")
    @RequestMapping(value = "/get", method = RequestMethod.GET)
    GeneralResponse<StudentDTO> getStudentById(Long id);

    @ApiOperation(value = "Update student account")
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    GeneralResponse<Void> updateStudent(UpdateStudentRequest request);

    @ApiOperation(value = "Delete student account")
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    GeneralResponse<Void> deleteStudent(Long id);



}
