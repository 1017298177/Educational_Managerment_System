package com.ed.service.impl;

import com.ed.mapper.UserMapper;
import com.ed.pojo.User;
import com.ed.service.UserBookService;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserBookServiceImpl implements UserBookService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public User who() {
        User user= (User) SecurityUtils.getSubject().getSession().getAttribute("user");

        return  userMapper.userbook(user.getUserSno());
    }
}
