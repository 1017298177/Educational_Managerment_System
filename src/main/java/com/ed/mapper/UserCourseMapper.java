package com.ed.mapper;

import com.ed.pojo.UserCourse;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * (UserCourse)表数据库访问层
 *
 * @author makejava
 * @since 2020-08-07 10:57:58
 */
public interface UserCourseMapper {

    UserCourse queryById(Integer userCourseId);

    List<UserCourse> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);

    List<UserCourse> queryAll(UserCourse userCourse);

    int insert(UserCourse userCourse);

    int update(UserCourse userCourse);

    int deleteById(Integer userCourseId);

    UserCourse distinctSelect(UserCourse userCourse);
}