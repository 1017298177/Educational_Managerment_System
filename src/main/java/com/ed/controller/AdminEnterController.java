package com.ed.controller;

import com.ed.pojo.*;
import com.ed.service.AdminEnterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("adminEnter")
public class AdminEnterController {
    @Autowired
    private AdminEnterService aes;



    @RequestMapping("toPageAddUser.do")
    public String toPageAddUser(){
        return "admin/addUser";
    }

    @RequestMapping("addUser.do")
    @ResponseBody
    public String addUser(Model model, User user) {
        int i = aes.addUser(user);
        if (i > 0) {
            model.addAttribute("message", "success");
        } else {
            model.addAttribute("message", "error");
        }
        return "success";
    }


    @RequestMapping("dataToShowUser.do")
     public String dataToShowUser(Model model,User user){
        Map<String, Object> userMap = aes.queryAllUser(user);
        model.addAttribute("user",user);
        model.addAttribute("mapList",userMap);
        return "admin/showUser";
    }
    @RequestMapping("updataToPage.do")
    public String updataToPage(int userId,Model model){
        User user=aes.queryUserById(userId);
        model.addAttribute("user",user);
        return "admin/update";
    }
    @RequestMapping("saveUpdate.do")
    @ResponseBody
    public String saveUpdate(User user){
        int i = aes.updateByuser(user);
        return "admin/showUser";
    }
    @RequestMapping("del.do")
    @ResponseBody
    public String deleted(int id){
        int i=aes.deletedByUserId(id);
        return "admin/showUser";
    }
   @RequestMapping("distributionRole.do")
    public String distributionRole(int userId,Model model){
       List<Role> roleList =   aes.queryAllRole();
        model.addAttribute("roleList",roleList);
        model.addAttribute("userId",userId);
       return "admin/distributionRole";
   }
   @RequestMapping("saveRole.do")
   @ResponseBody
    public String saveRole(UserRole userRole){
       System.out.println(userRole);
        int i=aes.saveRole(userRole.getUserId(),userRole.getRoleId());
        return "admin/showUser";
   }

   @RequestMapping("datePage.do")
   public String datePage(MyPage myPage, Model model){
      Map<String,Object> mapList = aes.pageMap(myPage);
      model.addAttribute("mapList",mapList);
        return "admin/datePage";
   }

   @RequestMapping("setDimePage.do")
    public String setDimePage(){
        return "admin/setDimePage";
   }
    @RequestMapping("setDime.ajax")
    @ResponseBody
    public int setDime(Date date){

        return aes.setDime(date);
    }

}
