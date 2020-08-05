package com.ed.controller;

import com.ed.pojo.Course;
import com.ed.service.TrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("trainController")
public class TrainController {
    @Autowired
    TrainService trainService;

    @RequestMapping("trainPage.do")
    public String trainPage(Course course, Model model){
       Map<String, Object> mapList= trainService.pageMap(course);
     model.addAttribute("mapList",mapList);
        return "student/trainPage";
    }

}
