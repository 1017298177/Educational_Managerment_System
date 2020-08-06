package com.ed.service.impl;

import com.ed.mapper.ClassMapper;
import com.ed.mapper.CourseMapper;
import com.ed.mapper.UserMapper;
import com.ed.pojo.Class;
import com.ed.pojo.Course;
import com.ed.pojo.User;
import com.ed.service.DistributionClassService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DistributionClassServiceImpl implements DistributionClassService {
@Autowired
    UserMapper userMapper;
    @Autowired
    CourseMapper courseMapper;
    @Autowired
    ClassMapper classMapper;
    @Override
    public Map<String, Object> queryTeacher(User user) {
        PageHelper.startPage(user.getPage(),user.getRow());
        List<User> teacherList = userMapper.queryAllTeacher(user);
        PageInfo<User> pageInfo = new PageInfo<User>(teacherList);
        Map<String, Object> mapList = new HashMap<>();
        mapList.put("list",pageInfo.getList());
        if(user.getPage()==pageInfo.getNavigateFirstPage()){
            mapList.put("prePage",1);
        }else {
            mapList.put("prePage",pageInfo.getPrePage());
        }
        if(user.getPage()==pageInfo.getNavigateLastPage()){
            mapList.put("nextPage",1);
        }else {
            mapList.put("nextPage",pageInfo.getNextPage());
        }
        mapList.put("total",pageInfo.getTotal());
        mapList.put("currentPage",user.getPage());
        mapList.put("countPage",pageInfo.getPages());
        mapList.put("firstPage",pageInfo.getNavigateFirstPage());
        mapList.put("lastPage",pageInfo.getNavigateLastPage());
        return mapList;
    }

    @Override
    public List<Course> queryClass(Course course) {
            course.setCourseClassState(0);
        List<Course>  courseList= courseMapper.queryClass(course);
        return courseList;
    }

    @Override
    public int savedis(Course course) {
        course.setCourseClassState(1);

        return courseMapper.updateByPrimaryKeySelective(course);
    }

    @Override
    public int saveClasstable(Course course) {
        Class c=new Class();
        c.setClassTecherSno(course.getUserSno());
        c.setClassDep(course.getCourseDepartment());
        c.setClassC(course.getCourseClass());
        c.setClassLocation(course.getCourseLocation());
        c.setClassNum(course.getCourseNumber().toString());
        c.setClassWeek(course.getCourseWeek());
        System.out.println(c);
        int i = classMapper.insertSelective(c);
        return 0;
    }

}
