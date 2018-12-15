package com.service.core.sevice;

import com.service.core.dao.CourseRepository;
import com.service.api.dto.CourseDTO;
import com.service.api.requset.CreateCourseRequest;
import com.service.api.requset.UpdateCourseRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CourseServiceImpl implements CourseService {

    private CourseRepository courseRepository;
@Autowired
    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public Long create(CreateCourseRequest request) {
        return null;
    }

    public CourseDTO get(Long id) {
        return null;
    }

    public void update(UpdateCourseRequest request) {

    }

    public void delete(Long id) {

    }

    public List<CourseDTO> getAll() {
        return null;
    }
}
