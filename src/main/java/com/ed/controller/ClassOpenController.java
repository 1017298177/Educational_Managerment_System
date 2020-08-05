package com.ed.controller;

import com.ed.pojo.Course;
import com.ed.service.ClassOpenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@RequestMapping("classOpenController")
public class ClassOpenController {
    @Autowired
    private ClassOpenService co;
    @RequestMapping("toPageOpenClassAdmin.do")
    public String toPageOpenClassAdmin(Course course, Model model){
            Map<String, Object> courseMap = co.queryCourseByPage(course);
          model.addAttribute("course",course);
            model.addAttribute("mapList",courseMap);
        return "ClassOpen/ClassOpenAdmin";
    }
    @RequestMapping("addCourse.do")
    public String addCourse(){
        return "ClassOpen/addCourse";
    }
    @RequestMapping("saveAddCourse.do")
    @ResponseBody
    public String saveAddCourse(Course course){

        int i= co.addCourse(course);
        return "ClassOpen/ClassOpenAdmin";
    }

    @RequestMapping("toUpdatePage.do")
    public String toUpdatePage(Model model,int courseId){

       Course course = co.queryByCourseId(courseId);
        model.addAttribute("course",course);
        return "ClassOpen/updateCourse";
    }

    @RequestMapping("saveUpdateCourse.ajax")
    @ResponseBody
    public String saveUpdateCourse(Course course){
        //System.out.println("==save==="+course);
        int i=co.saveUpdateCourse(course);


        return "";
    }
    @RequestMapping("deleted.do")
    @ResponseBody
    public String deleted(int courseId){
       int i= co.deletedByCourseId(courseId);

        return "ClassOpen/ClassOpenAdmin";
    }


}
