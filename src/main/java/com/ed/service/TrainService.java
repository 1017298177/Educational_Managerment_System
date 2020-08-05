package com.ed.service;

import com.ed.pojo.Course;

import java.util.List;
import java.util.Map;

public interface TrainService {
    Map<String, Object> pageMap(Course course);
}
