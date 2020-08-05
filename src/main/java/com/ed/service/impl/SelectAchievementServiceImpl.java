package com.ed.service.impl;

import com.ed.mapper.AchievementMapper;
import com.ed.pojo.Achievement;
import com.ed.pojo.Course;
import com.ed.pojo.User;
import com.ed.service.SelectAchievementService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SelectAchievementServiceImpl implements SelectAchievementService {

   @Autowired
    AchievementMapper achievementMapper;


    @Override
    public Map<String, Object> pageMap(Achievement achievement) {
        User user = (User) SecurityUtils.getSubject().getSession().getAttribute("user");
        achievement.setAchievementUserSno(Integer.parseInt(user.getUserSno()));
        PageHelper.startPage(achievement.getPage(),achievement.getRow());
        List<Achievement> achievements = achievementMapper.selectAchievement(achievement);
        PageInfo<Achievement> pageInfo = new PageInfo<>(achievements);
        Map<String, Object> mapList = new HashMap<>();
        mapList.put("list",pageInfo.getList());
        if(achievement.getPage()==pageInfo.getNavigateFirstPage()){
            mapList.put("prePage",1);
        }else {
            mapList.put("prePage",pageInfo.getPrePage());
        }
        if(achievement.getPage()==pageInfo.getNavigateLastPage()){
            mapList.put("nextPage",1);
        }else {
            mapList.put("nextPage",pageInfo.getNextPage());
        }
        mapList.put("total",pageInfo.getTotal());
        mapList.put("currentPage",achievement.getPage());
        mapList.put("countPage",pageInfo.getPages());
        mapList.put("firstPage",pageInfo.getNavigateFirstPage());
        mapList.put("lastPage",pageInfo.getNavigateLastPage());
        return mapList;
    }
}
