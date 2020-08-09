package com.ed.service.impl;

import com.ed.mapper.*;
import com.ed.pojo.Achievement;
import com.ed.pojo.Class;
import com.ed.pojo.FileResources;
import com.ed.pojo.User;
import com.ed.pojo.UserCourse;
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
    UserCourseMapper userCourseMapper;
    @Autowired
    FileResourcesMapper fileResourcesMapper;
    @Autowired
    AchievementMapper achievementMapper;
    @Autowired
    ClassMapper classMapper;

    @Test
    public void selectRole() {
        List<Class> classes = classMapper.selectClassByUserSon("20202");
        System.out.println(classes);
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