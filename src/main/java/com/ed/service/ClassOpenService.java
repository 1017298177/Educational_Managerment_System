package com.ed.service;

import com.ed.pojo.Course;

import java.util.HashMap;
import java.util.Map;

public interface ClassOpenService {
    Map<String, Object> queryCourseByPage(Course course);

    int addCourse(Course course);

    Course queryByCourseId(int courseId);

    int saveUpdateCourse(Course course);

    int deletedByCourseId(int courseId);
}
