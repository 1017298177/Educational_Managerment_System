package com.ed.service.impl;

import com.ed.mapper.UserCourseMapper;
import com.ed.pojo.UserCourse;
import com.ed.service.UserCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;




@Service
public class UserCourseServiceImpl implements UserCourseService {

    @Autowired
    UserCourseMapper userCourseMapper;


    @Override
    public int insert(UserCourse userCourse) {
        return userCourseMapper.insert(userCourse);
    }


}