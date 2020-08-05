package com.ed.service;

import com.ed.pojo.Course;

import java.util.Map;

public interface SelectCourseService {


    Map<String, Object> pageMap(Course course);

    void selectCourse(int courseId);

    void withDrawCourse(int courseId);

    String thinkTime();
}
