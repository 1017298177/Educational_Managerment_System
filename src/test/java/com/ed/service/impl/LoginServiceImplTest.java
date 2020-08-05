package com.ed.service.impl;

import com.ed.mapper.AchievementMapper;
import com.ed.mapper.FileResourcesMapper;
import com.ed.mapper.UserMapper;
import com.ed.pojo.Achievement;
import com.ed.pojo.FileResources;
import com.ed.pojo.User;
import com.ed.service.LoginService;
import com.ed.utils.EncryptionUtil;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.servlet.support.JstlUtils;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring.xml"})
public class LoginServiceImplTest {

    @Autowired
    UserMapper mapper;
    @Autowired
    FileResourcesMapper fileResourcesMapper;
    @Autowired
    AchievementMapper achievementMapper;

    @Test
    public void selectRole() {
        java.util.Date dateTime = new java.util.Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //当前系统时间
        String format1 = format.format(dateTime);
        String courseDateStart = "2020-08-02 17:17:06";
        String courseDateEnd = "2020-08-08 17:17:06";
        int compareTo = "2020-08-05 17:17:06".compareTo(courseDateStart);
        int compareTo1= format1.compareTo(courseDateEnd);
        //选课未开始
        System.out.println(compareTo);
        System.out.println(compareTo1);
        //选课已截止
    }

    @Test
    public void test1() {
        SimpleHash encryption = EncryptionUtil.encryption("20203", "qqq");
        Map<String,String> param = new HashMap<>();
        param.put("encryption",encryption.toString());
        param.put("userSno","20203");
        String db_password = mapper.confimPassword(param);
        if(db_password!=null){
            System.out.println("1111");
        }else {
            System.out.println("2222");
        }

    }
}