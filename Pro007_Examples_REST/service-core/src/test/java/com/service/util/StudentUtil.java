package com.service.util;

import com.service.core.domain.Student;

import java.util.Calendar;

public final class StudentUtil {

    public static final Long BAD_STUDENT_ID = 1234567890L;

    public static Student createSingleStudentRecord() {
        Student student = new Student();
        student.setName("Arsen");
        student.setSurname("Klochan");
        student.setAge(30);
        student.setLastUpdate(Calendar.getInstance().getTime());
        return student;
    }
}
