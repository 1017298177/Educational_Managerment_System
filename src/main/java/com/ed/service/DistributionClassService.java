package com.ed.service;

import com.ed.pojo.Course;
import com.ed.pojo.User;

import java.util.List;
import java.util.Map;

public interface DistributionClassService {
    Map<String, Object> queryTeacher(User user);

    List<Course> queryClass(Course course);

    int savedis(Course course);
    int saveClasstable(Course course);
}
