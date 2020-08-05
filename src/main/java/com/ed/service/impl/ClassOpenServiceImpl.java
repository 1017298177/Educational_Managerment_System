package com.ed.service.impl;

import com.ed.mapper.CourseMapper;
import com.ed.pojo.Course;
import com.ed.pojo.FileResources;
import com.ed.service.ClassOpenService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ClassOpenServiceImpl implements ClassOpenService {
@Autowired
    CourseMapper courseMapper;

    @Override
    public Map<String, Object> queryCourseByPage(Course course) {
        PageHelper.startPage(course.getPage(),course.getRow());
        List<Course> courseList = courseMapper.queryAll(course);
        PageInfo<Course> pageInfo = new PageInfo<Course>(courseList);
        Map<String, Object> mapList = new HashMap<>();
        mapList.put("list",pageInfo.getList());
        if(course.getPage()==pageInfo.getNavigateFirstPage()){
            mapList.put("prePage",1);
        }else {
            mapList.put("prePage",pageInfo.getPrePage());
        }
        if(course.getPage()==pageInfo.getNavigateLastPage()){
            mapList.put("nextPage",1);
        }else {
            mapList.put("nextPage",pageInfo.getNextPage());
        }
        mapList.put("total",pageInfo.getTotal());
        mapList.put("currentPage",course.getPage());
        mapList.put("countPage",pageInfo.getPages());
        mapList.put("firstPage",pageInfo.getNavigateFirstPage());
        mapList.put("lastPage",pageInfo.getNavigateLastPage());
        return mapList;
    }

    @Override
    public int addCourse(Course course) {
            course.setCourseClassState(0);
        return courseMapper.insertSelective(course);
    }

    @Override
    public Course queryByCourseId(int courseId) {
        return courseMapper.selectByPrimaryKey(courseId);
    }

    @Override
    public int saveUpdateCourse(Course course) {
      return  courseMapper.updateByPrimaryKeySelective(course);
    }

    @Override
    public int deletedByCourseId(int courseId) {
        return courseMapper.deleteByPrimaryKey(courseId);
    }
}
