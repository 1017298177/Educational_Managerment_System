package com.ed.controller;

import com.ed.pojo.Course;
import com.ed.service.SelectCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@RequestMapping("selectCourseController")
public class SelectCourseController {
    @Autowired
    SelectCourseService selectCourseService;

   //判断选课时间是否结束
    @RequestMapping("thinkTime.ajax")
    @ResponseBody
    public String thinkTime(){
       String flag = selectCourseService.thinkTime();
        return  flag;
    }

    @RequestMapping("selectCoursePage.do")
    public String selectCoursePage(Course course, Model model){
      Map<String,Object> mapList = selectCourseService.pageMap(course);
      model.addAttribute("mapList",mapList);
        return "student/selectCoursePage";
    }
    //选课结束页面
    @RequestMapping("courseAfter.do")
    public String courseAfter(){
        return "student/courseAfter";
    }
    //选课未开始页面
    @RequestMapping("courseBefore.do")
    public String courseBefore(){
        return "student/courseBefore";
    }

    @RequestMapping("selectCourse.do")
    public String selectCourse(int courseId){
        //选中课程
        selectCourseService.selectCourse(courseId);
        return "redirect:/selectCourseController/selectCoursePage.do";
    }


    @RequestMapping("updateCourseChecked.do")
    public String updateCourseChecked(int courseId){
        //撤销课程
        selectCourseService.withDrawCourse(courseId);
        return "redirect:/selectCourseController/selectCoursePage.do";
    }

}
