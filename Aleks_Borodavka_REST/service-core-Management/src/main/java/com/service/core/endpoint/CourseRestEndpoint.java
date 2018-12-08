package com.service.core.endpoint;

import com.service.api.dto.ClientRecordDTO;
import com.service.api.dto.CourseRecordDTO;
import com.service.api.endpoint.CourseEndpoint;
import com.service.api.request.GeneralRequest;
import com.service.api.request.parameters.CourseParametrs;
import com.service.api.response.GeneralResponse;
import com.service.core.service.course.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CourseRestEndpoint implements CourseEndpoint {

    private CourseService courseService;

    @Autowired
    public CourseRestEndpoint(CourseService courseService) {
        this.courseService = courseService;
    }

    public GeneralResponse<Long> createCourseRecord(
            @RequestBody GeneralRequest<Void, CourseParametrs> createCourseRequest) {
        return new GeneralResponse<>(200L,
                courseService.createCourseRecord(createCourseRequest.getParameters()));
    }

    public GeneralResponse<Void> deleteCourseRecord(
            @RequestParam Long id) {
        courseService.deleteCourseRecord(id);
        return new GeneralResponse<>(200L, null);
    }

    public GeneralResponse<CourseRecordDTO> getCourseById(
            @RequestParam Long id) {
        return new GeneralResponse<>(200L, courseService.getCourseById(id));
    }

    public GeneralResponse<List<CourseRecordDTO>> getAllCourseRecords() {
        return new GeneralResponse<>(200L, courseService.getAllCourseRecords());
    }

    public GeneralResponse<List<ClientRecordDTO>> getAllClientRecordsOnCourse(
            @RequestParam Long courseId) {
        return new GeneralResponse<>(200L, courseService.getAllClientRecordsOnCourse(courseId));
    }

    public GeneralResponse<Void> signClientOnCourse(
            @RequestParam Long courseId,
            @RequestParam Long clientId) {
        courseService.signClientOnCourse(courseId, clientId);
        return new GeneralResponse<>(200L, null);
    }

    public GeneralResponse<Void> updateCourseRecord(
            @RequestBody GeneralRequest<Long, CourseParametrs> updateCourseRequest) {
        courseService.updateCourseRecord(updateCourseRequest);
        return new GeneralResponse<>(200L, null);
    }
}
