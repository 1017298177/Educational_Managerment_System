package com.ed.controller;

import com.ed.mapper.UserMapper;
import com.ed.pojo.Course;
import com.ed.pojo.User;
import com.ed.service.DistributionClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("distributionClassController")
public class DistributionClassController {
    @Autowired
    private DistributionClassService dc;
    @RequestMapping("toDistribution.do")
    public String toDistribution(User user,Model model){
        Map<String, Object> teacherMap= dc.queryTeacher(user);

        model.addAttribute("teacherMap",teacherMap);
        return "distributionClass/distributionClassAdmin";
    }
    @RequestMapping("distributionClass.do")
    public String distributionClass(String userName,String userSno,Model model){

        model.addAttribute("teacherName",userName);
        model.addAttribute("teacherSno",userSno);
        //查询课程  1，系别   2，年级

        return "distributionClass/dclasspage";
    }
    @RequestMapping("queryClass.do")
    public String queryClass(Course course,Model model,String teacherName,String teacherSno ){

     List<Course> courseList= dc.queryClass(course);
      model.addAttribute("teacherNameL",teacherName);
      model.addAttribute("teacherSnoL",teacherSno);
    model.addAttribute("courseList",courseList);

         return "distributionClass/dclasspage";
    }
@RequestMapping("toDistributionPage.do")
    public String toDistributionPage(String teacherNameL,String teacherSnoL,int courseId,String courseDep,Model model){
                model.addAttribute("teacherNameL",teacherNameL);
                model.addAttribute("teacherSnoL",teacherSnoL);
                model.addAttribute("courseId",courseId);
                model.addAttribute("courseDep",courseDep);


        return "distributionClass/showDpage";
}
@RequestMapping("savedis.ajax")
    @ResponseBody
    public String savedis(Course course){

      int i=dc.savedis(course);
      int j=dc.saveClasstable(course);
        return "success";
}
}
