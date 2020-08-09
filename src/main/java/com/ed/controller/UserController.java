package com.ed.controller;

import com.ed.mapper.CourseMapper;
import com.ed.mapper.UserMapper;
import com.ed.pojo.Class;
import com.ed.pojo.Course;
import com.ed.pojo.User;
import com.ed.service.ClassService;
import com.ed.service.CourseService;
import com.ed.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("user")
public class UserController {
   /* @Autowired
    UserMapper userMapper;*/
   @Autowired
   ClassService classService;
    @Autowired
    CourseService courseService;
    @Autowired
    UserService userService;
    @RequestMapping("classInfo.do")
    public String classInfo(ModelMap map){
        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession();
        User user=new User();
        user= (User) session.getAttribute("user");
        System.err.println(user);
        String userSno= user.getUserSno();
        List<Class> classes=classService.selectClassBySno(userSno);
        for (Class class1:classes){
            System.err.println("--------"+class1.toString());
        }
        map.addAttribute("classes",classes);
        return "login/class";
    }
    @RequestMapping("studentInfo.do")
    public String studentInfo(Class class1 ,ModelMap map){
        System.out.println("进来了");
        System.out.println(class1.toString());
        String class1ClassC=class1.getClassC();
        System.out.println(class1ClassC);
        List<User> users=userService.selectUserByClass(class1ClassC);

           for (User user : users) {
               System.out.println("!!!!!!!"+user.toString());
           }
           map.addAttribute("users", users);
           return "login/stu";


    }
}
