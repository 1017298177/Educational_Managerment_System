package com.ed.controller;

import com.ed.pojo.Class;
import com.ed.pojo.Course;
import com.ed.pojo.FileResources;
import com.ed.pojo.User;
import com.ed.service.ClassService;
import com.ed.service.CourseService;
import com.ed.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("course")
public class CourseController {
    @Autowired
    ClassService classService;
    @Autowired
    CourseService courseService;
    @Autowired
    UserService userService;
    @RequestMapping("weekTime.do")
    public String weekTime(FileResources fileResources, Model model) {
        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession();
        User user=new User();
        user= (User) session.getAttribute("user");
        System.err.println(user);
        String userSno= user.getUserSno();
        List<Class> classes=classService.selectClassBySno(userSno);
        for (Class course:classes){
        }

        model.addAttribute("classes",classes);
        return "login/class03";
    }
    @RequestMapping("classTime.do")
    public String classTime(Class class1, Model model) {
        System.out.println(class1.toString());
        String class1ClassC=class1.getClassC();
        System.out.println(class1ClassC);
        List<Class> classes=classService.selectTableByC(class1ClassC);
        for (Class classe:classes
             ) {
        }
       model.addAttribute("classes",classes);
        return "login/weektime";
    }
}
