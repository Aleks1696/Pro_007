package com.service.core.service.course;

import com.service.api.dto.ClientRecordDTO;
import com.service.api.dto.CourseRecordDTO;
import com.service.api.request.GeneralRequest;
import com.service.api.request.parameters.CourseParametrs;

import java.util.List;

public interface CourseService {

    Long createCourseRecord(CourseParametrs courseParametrs);

    void deleteCourseRecord(Long id);

    CourseRecordDTO getCourseById(Long id);

    List<CourseRecordDTO> getAllCourseRecords();

    List<ClientRecordDTO> getAllClientRecordsOnCourse(Long courseId);

    void signClientOnCourse(Long courseId, Long clientId);

    void updateCourseRecord(GeneralRequest<Long, CourseParametrs> updateCourseRequest);

}
