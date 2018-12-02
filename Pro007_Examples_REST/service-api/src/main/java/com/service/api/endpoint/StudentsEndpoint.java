package com.service.api.endpoint;

import com.service.api.dto.StudentDTO;
import com.service.api.request.CreateStudentRequest;
import com.service.api.request.UpdateStudentRequest;
import com.service.api.response.GeneralErrorResponse;
import com.service.api.response.GeneralResponse;
import io.swagger.annotations.*;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@SwaggerDefinition(
        info = @Info(description = "REST API", version = "1.0.0", title = "REST API"),
        produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
        schemes = SwaggerDefinition.Scheme.HTTPS
)
@Api(tags = "Students REST Endpoint")
@RequestMapping("/api/students")
public interface StudentsEndpoint {

    @ApiOperation(value = "Создание учетной записи студента")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Учетная запись успешно создана")
    })
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    GeneralResponse<Long> createStudent(CreateStudentRequest request);

    @ApiOperation(value = "Получение учетной записи студениа по ID")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Учетная запись получена"),
            @ApiResponse(code = 500, message = "Учетная запись не найдена",
                         response = GeneralErrorResponse.class)
    })
    @RequestMapping(value = "/get", method = RequestMethod.GET)
    GeneralResponse<StudentDTO> getStudentById(Long id);

    @ApiOperation(value = "Обновление учетной записи студента")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Учетная запись обновлена"),
            @ApiResponse(code = 500, message = "Учетная запись не найдена",
                         response = GeneralErrorResponse.class)
    })
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    GeneralResponse<Void> updateStudent(UpdateStudentRequest request);

    @ApiOperation(value = "Удаление учетной записи студента")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Учетная запись удалена"),
            @ApiResponse(code = 500, message = "Учетная запись не найдена",
                        response = GeneralErrorResponse.class)
    })
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    GeneralResponse<Void> deleteStudent(Long id);

}
