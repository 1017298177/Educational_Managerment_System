package com.ed.service.impl;

import com.ed.mapper.UserMapper;
import com.ed.pojo.FileResources;
import com.ed.pojo.User;
import com.ed.service.StudentMessageService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
class StudentMessageServiceImpl implements StudentMessageService {

    @Autowired
    private UserMapper userMapper;
    @Override
    public User selectstudent(User user) {
        return  userMapper.queryPersonByPersonName(user.getUserSno());
    }



}
