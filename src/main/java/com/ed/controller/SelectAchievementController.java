package com.ed.controller;

import com.ed.pojo.Achievement;
import com.ed.service.SelectAchievementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("selectAchievementController")
public class SelectAchievementController {

    @Autowired
    SelectAchievementService achievementService;


    @RequestMapping("achievementPage.do")
    public String achievementPage(Achievement achievement, Model model){
        Map<String,Object> mapList = achievementService.pageMap(achievement);
        model.addAttribute("achievement",achievement);
        model.addAttribute("mapList",mapList);
        return "student/achievementPage";
    }

}
