package com.service.core.sevice;

import com.service.api.dto.CourseDTO;
import com.service.api.requset.CreateCourseRequest;
import com.service.api.requset.UpdateCourseRequest;

import java.util.List;

public interface CourseService {
    Long create(CreateCourseRequest request);
    CourseDTO get (Long id);
    void update(UpdateCourseRequest request);
    void delete (Long id);
    List<CourseDTO> getAll ();
}
