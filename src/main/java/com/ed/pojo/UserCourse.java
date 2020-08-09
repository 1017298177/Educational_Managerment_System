package com.ed.pojo;

import java.io.Serializable;

/**
 * (UserCourse)实体类
 *
 * @author makejava
 * @since 2020-08-07 10:55:58
 */
public class UserCourse implements Serializable {
    private static final long serialVersionUID = -49392398085404434L;
    
    private Integer userCourseId;
    
    private String stuSno;
    
    private Integer courseId;


    public Integer getUserCourseId() {
        return userCourseId;
    }

    public void setUserCourseId(Integer userCourseId) {
        this.userCourseId = userCourseId;
    }

    public String getStuSno() {
        return stuSno;
    }

    public void setStuSno(String stuSno) {
        this.stuSno = stuSno;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

}