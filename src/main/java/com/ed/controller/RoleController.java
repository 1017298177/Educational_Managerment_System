package com.ed.controller;

import com.ed.mapper.CourseMapper;
import com.ed.pojo.Achievement;
import com.ed.pojo.Class;
import com.ed.pojo.Course;
import com.ed.pojo.FileResources;
import com.ed.pojo.User;
import com.ed.service.AchievementService;
import com.ed.service.ClassService;
import com.ed.service.CourseService;
import com.ed.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.omg.PortableInterceptor.USER_EXCEPTION;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("role")
public class RoleController {
    @Autowired
    ClassService classService;
    @Autowired
    CourseService courseService;
    @Autowired
    UserService userService;
    @Autowired
    CourseMapper courseMapper;

    @Autowired
    AchievementService achievementService;
    @RequestMapping("classInfo.do")
    public String weekTime(FileResources fileResources, Model map) {
        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession();
        User user=new User();
        user= (User) session.getAttribute("user");
        System.err.println(user);
        String userSno= user.getUserSno();
        List<Class> classes=classService.selectClassBySno(userSno);
        map.addAttribute("classes",classes);
        return "login/class02";
    }
    @RequestMapping("studentInfo.do")
    public String studentInfo(Class class1,User user , ModelMap map){
        String courseClass=class1.getClassC();
        List<User> users=userService.selectUserByClass(courseClass);
        User user1 = (User) SecurityUtils.getSubject().getSession().getAttribute("user");
        List<Achievement> achievements=achievementService.selectAchievement();
        map.addAttribute("achievements",achievements);
        String courseName = courseMapper.selectCouseName(user1.getUserSno());
         map.addAttribute("courseName",courseName);
        map.addAttribute("users",users);
        return "login/gradeInset";
}

    @RequestMapping("updateAchievements.do")
    public String updateAchievements(Achievement achievement, ModelMap map) {
        Achievement achievement1= achievementService.selectAchievementById(achievement.getAchievementId());
        map.addAttribute("achievement",achievement1);
        return "login/updateAchievements";
}

    @RequestMapping("updateSuccess.do")
    public String updateSuccess(Achievement achievement, ModelMap map) {
        int n=achievementService.updateAchievementByAchievement(achievement);
        if(n>0){
            return "redirect:/role/classInfo.do";
        }else {
        return "login/updateAchievements";
        }
    }

    @RequestMapping("insertAchievements.do")
    public String insertAchievements(Achievement achievement , ModelMap map) {
        Achievement achievement1=
                achievementService.selectAchievementById(achievement.getAchievementId());
        map.addAttribute("achievement",achievement1);
        return "login/insertAchievements";
    }
    @RequestMapping("insertSuccess.do")
    public String insertSuccess(Achievement achievement , ModelMap map) {
        int n=achievementService.updateAchievementByAchievement(achievement);
        if(n>0){
            return "redirect:/role/classInfo.do";
        }else {
            return "login/insertAchievements";
        }
    }
    }