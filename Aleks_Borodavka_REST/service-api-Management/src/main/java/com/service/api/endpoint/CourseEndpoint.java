package com.service.api.endpoint;

import com.service.api.dto.ClientRecordDTO;
import com.service.api.dto.CourseRecordDTO;
import com.service.api.request.GeneralRequest;
import com.service.api.request.parameters.CourseParametrs;
import com.service.api.response.GeneralErrorResponse;
import com.service.api.response.GeneralResponse;
import io.swagger.annotations.*;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@SwaggerDefinition(
        info = @Info(description = "Management API", version = "1.0.0", title = "Management API"),
        produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
        schemes = SwaggerDefinition.Scheme.HTTPS
)
@Api(tags = "Course Service", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, protocols = "https")
@RequestMapping(value = "management/course")
public interface CourseEndpoint {

    @ApiOperation(value = "Create new course record")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK - Course record is created")
    })
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    GeneralResponse<Long> createCourseRecord(
            GeneralRequest<Void, CourseParametrs> createCourseRequest);


    @ApiOperation(value = "Delete course by ID")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK - Course record is deleted"),
            @ApiResponse(code = 500, message = "FAIL - Internal server error",
                    response = GeneralErrorResponse.class)
    })
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    GeneralResponse<Void> deleteCourseRecord(Long id);


    @ApiOperation(value = "Read course record by ID")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK - Course record is returned"),
            @ApiResponse(code = 500, message = "FAIL - Internal server error",
                    response = GeneralErrorResponse.class)
    })
    @RequestMapping(value = "/get", method = RequestMethod.GET)
    GeneralResponse<CourseRecordDTO> getCourseById(Long id);


    @ApiOperation(value = "Get all registered courses")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK - Course records is returned")
    })
    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    GeneralResponse<List<CourseRecordDTO>> getAllCourseRecords();


    @ApiOperation(value = "Get registered clients on course")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK - Client records is returned")
    })
    @RequestMapping(value = "/get/clients", method = RequestMethod.GET)
    GeneralResponse<List<ClientRecordDTO>> getAllClientRecordsOnCourse(Long courseId);

    @ApiOperation(value = "Sing client on course")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Client is signed on course"),
            @ApiResponse(code = 500, message = "FAIL - Internal server error",
                    response = GeneralErrorResponse.class)
    })
    @RequestMapping(value = "/sing/client", method = RequestMethod.PUT)
    GeneralResponse<Void> signClientOnCourse(Long courseId, Long clientId);


    @ApiOperation(value = "Update course record by ID")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK - Course record is updated"),
            @ApiResponse(code = 500, message = "FAIL - Internal server error",
                    response = GeneralErrorResponse.class)
    })
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    GeneralResponse<Void> updateCourseRecord(
            GeneralRequest<Long, CourseParametrs> updateCourseRequest);

}
