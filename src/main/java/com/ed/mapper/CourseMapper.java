package com.ed.mapper;

import com.ed.pojo.Course;
import com.ed.pojo.User;

import java.util.List;

public interface CourseMapper {
    int deleteByPrimaryKey(Integer courseId);

    int insert(Course record);

    int insertSelective(Course record);

    Course selectByPrimaryKey(Integer courseId);

    int updateByPrimaryKeySelective(Course record);

    int updateByPrimaryKey(Course record);


    List<Course> selectTrain(User user);

    List<Course> selectCourse(Course course);

    void checkedCourse(int courseId);

    void withDrawCourse(int courseId);

    List<Course> queryAll(Course course);

    List<Course> queryClass(Course course);

    List<Course> selectClassBySno(String userSno);

    String selectCouseName(String userSno);

    List<Course> selectByUserSon(String userSno);
}