package com.service.core.util;

import com.service.api.request.parameters.CourseParametrs;
import com.service.core.domain.CourseRecord;

public class CourseUtil {

    public static Long BAD_COURSE_ID = 21341512152L;

    public static CourseParametrs createCourseParameters(){
        CourseParametrs courseParametrs = new CourseParametrs();
        courseParametrs.setTitle("Test_Course");
        courseParametrs.setDescription("Test_Course");
        return courseParametrs;
    }

    public static CourseRecord createCourseRecord(){
        CourseRecord courseRecord = new CourseRecord();
        courseRecord.setTitle("Test_Course");
        courseRecord.setDescription("Test_Course");
        return courseRecord;
    }

    public static CourseParametrs updatedCourseParameters(){
        CourseParametrs courseParametrs = new CourseParametrs();
        courseParametrs.setTitle("Test_Course_Updated");
        courseParametrs.setDescription("Test_Course_Updated");
        return courseParametrs;
    }

}
