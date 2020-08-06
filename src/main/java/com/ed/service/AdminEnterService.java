package com.ed.service;

import com.ed.pojo.Date;
import com.ed.pojo.MyPage;
import com.ed.pojo.Role;
import com.ed.pojo.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface AdminEnterService {
    int  addUser(User user);

    Map<String, Object> queryAllUser(User user);

    User queryUserById(int userId);

    int updateByuser(User user);

    int deletedByUserId(int userId);

     List<Role> queryAllRole();

    int saveRole(int userId, int roleId);

    Map<String, Object> pageMap(MyPage myPage);

    int setDime(Date date);

    public int queryRoleByUserId(int userId);
}
