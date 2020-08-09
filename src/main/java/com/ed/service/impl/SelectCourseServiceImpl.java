package com.ed.service.impl;

import com.ed.mapper.CourseMapper;
import com.ed.mapper.DateMapper;
import com.ed.mapper.UserCourseMapper;
import com.ed.pojo.Course;
import com.ed.pojo.Date;
import com.ed.pojo.User;
import com.ed.pojo.UserCourse;
import com.ed.service.SelectCourseService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SelectCourseServiceImpl implements SelectCourseService {

    @Autowired
    CourseMapper courseMapper;
    @Autowired
    DateMapper dateMapper;
    @Autowired
    UserCourseMapper userCourseMapper;

    @Override
    public Map<String, Object> pageMap(Course course) {
        User user = (User) SecurityUtils.getSubject().getSession().getAttribute("user");
        course.setCourseSemester(user.getUserSemester());
        course.setCourseGrade(user.getUserCollege());
        course.setCourseDepartment(user.getUserDep());
        PageHelper.startPage(course.getPage(),course.getRow());
        List<Course> courses = courseMapper.selectCourse(course);
        PageInfo<Course> pageInfo = new PageInfo<>(courses);
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
    public void selectCourse(int courseId) {
        User user = (User) SecurityUtils.getSubject().getSession().getAttribute("user");
        UserCourse userCourse = new UserCourse();
        userCourse.setStuSno(user.getUserSno());
        userCourse.setCourseId(courseId);
        UserCourse userCourse1 = userCourseMapper.distinctSelect(userCourse);
       if(userCourse1==null){
         userCourseMapper.insert(userCourse);
        }

        HashMap map = new HashMap();
        courseMapper.checkedCourse(courseId);
    }

    @Override
    public void withDrawCourse(int courseId) {
        courseMapper.withDrawCourse(courseId);
    }

    @Override
    public String thinkTime() {
        User user = (User) SecurityUtils.getSubject().getSession().getAttribute("user");
        Date date = dateMapper.selectDateBySemester(user.getUserSemester());
        java.util.Date dateTime = new java.util.Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        //当前系统时间
        String format1 = format.format(dateTime);
        String courseDateStart = date.getCourseDateStart();
        String courseDateEnd = date.getCourseDateEnd();
        int compareTo = format1.compareTo(courseDateStart);
        int compareTo1= format1.compareTo(courseDateEnd);
        //选课未开始
        if(compareTo<0){
            return "before";
        }
        //选课已截止
        if(compareTo1>0){
            return "after";
        }
        //选课
        if(compareTo>0&&compareTo1<0){
            return "true";
        }
        return null;
    }
}
