package com.ed.controller;

import com.ed.pojo.Achievement;
import com.ed.pojo.User;
import com.ed.service.MakeupstudentService;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.jws.soap.SOAPBinding;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("makeupstudentController")
public class MakeupstudentController {

    @Autowired
    MakeupstudentService makeupstudentService;

    @RequestMapping("makeupstudent.do")
    public String makeupstudent(Model model){
        User user = makeupstudentService.selectmakeupstudet();
        if(user==null){
            model.addAttribute("achievements",new ArrayList<Achievement>());
        }else {
            model.addAttribute("achievements", user.getAchievements());
        }
        return "student/MakeupStudent";
    }
}
