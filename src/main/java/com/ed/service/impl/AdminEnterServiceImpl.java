package com.ed.service.impl;

import com.ed.mapper.DateMapper;
import com.ed.mapper.RoleMapper;
import com.ed.mapper.UserMapper;
import com.ed.mapper.UserRoleMapper;
import com.ed.pojo.*;
import com.ed.service.AdminEnterService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AdminEnterServiceImpl implements AdminEnterService {
    @Autowired
    UserMapper um;
    @Autowired
    DateMapper dateMapper;
    @Autowired
    RoleMapper roleMapper;
    @Autowired
    private UserRoleMapper userRoleMapper;
    public int  addUser(User user){
        String userSno = user.getUserSno();
        user.setUserCollege("大一");
        user.setUserSemester("2019-2020-2");
        user.setUserImage(userSno+".jpg");
        //设置默认密码为123456
        //设置加密方式
        String algorithmName="MD5";
        //设置待加密的原密码
        Object source="123456";
        //设置加盐方式(一般来说都是以用户名来加盐)
        Object salt= ByteSource.Util.bytes(userSno);
        //加密次数
        int hashIterations=1024;
        SimpleHash newPassword=new SimpleHash(algorithmName, source, salt, hashIterations);
        //设置密码
        user.setUserPassword(newPassword.toString());
        int i = um.insertSelective(user);
        return i;
    }

    @Override
    public Map<String, Object> queryAllUser(User user) {
        PageHelper.startPage(user.getPage(),user.getRow());
        List<User> courseList = um.queryUserByPage(user);
        PageInfo<User> pageInfo = new PageInfo<User>(courseList);
        Map<String, Object> mapList = new HashMap<>();
        mapList.put("list",pageInfo.getList());
        if(user.getPage()==pageInfo.getNavigateFirstPage()){
            mapList.put("prePage",1);
        }else {
            mapList.put("prePage",pageInfo.getPrePage());
        }
        if(user.getPage()==pageInfo.getNavigateLastPage()){
            mapList.put("nextPage",1);
        }else {
            mapList.put("nextPage",pageInfo.getNextPage());
        }
        mapList.put("total",pageInfo.getTotal());
        mapList.put("currentPage",user.getPage());
        mapList.put("countPage",pageInfo.getPages());
        mapList.put("firstPage",pageInfo.getNavigateFirstPage());
        mapList.put("lastPage",pageInfo.getNavigateLastPage());
        return mapList;
    }

    @Override
    public User queryUserById(int userId) {
        User user = um.selectByPrimaryKey(userId);
        return user;
    }

    @Override
    public int updateByuser(User user) {
        int i = um.updateByPrimaryKeySelective(user);
        return i;
    }

    @Override
    public int deletedByUserId(int userId) {
        return um.deleteByPrimaryKey(userId);
    }

    @Override
    public List<Role> queryAllRole() {

        List<Role> roleList=roleMapper.queryAllRole();
        return roleList;
    }

    @Override
    public int saveRole(int userId, int roleId) {
        UserRole  userRole=new UserRole();
        userRole.setUserId(userId);
        userRole.setRoleId(roleId);
        userRoleMapper.deleteByUserId(userId);
        return userRoleMapper.insertSelective(userRole);
    }

    @Override
    public Map<String, Object> pageMap(MyPage myPage) {
        PageHelper.startPage(myPage.getPage(),myPage.getRow());
        List<Date> dates = dateMapper.queryAll();
        PageInfo<Date> pageInfo = new PageInfo<Date>(dates);
        Map<String, Object> mapList = new HashMap<>();
        mapList.put("list",pageInfo.getList());
        if(myPage.getPage()==pageInfo.getNavigateFirstPage()){
            mapList.put("prePage",1);
        }else {
            mapList.put("prePage",pageInfo.getPrePage());
        }
        if(myPage.getPage()==pageInfo.getNavigateLastPage()){
            mapList.put("nextPage",1);
        }else {
            mapList.put("nextPage",pageInfo.getNextPage());
        }
        mapList.put("total",pageInfo.getTotal());
        mapList.put("currentPage",myPage.getPage());
        mapList.put("countPage",pageInfo.getPages());
        mapList.put("firstPage",pageInfo.getNavigateFirstPage());
        mapList.put("lastPage",pageInfo.getNavigateLastPage());
        return mapList;
    }

    @Override
    public int setDime(Date date) {

        dateMapper.deleteBySemester(date.getSemester());

        return dateMapper.insertSelective(date);
    }
    @Override
    public int queryRoleByUserId(int userId) {

        String roleByUserId = userRoleMapper.queryRoleByUserId(userId);

        if (roleByUserId !=null){
            int i = Integer.parseInt(roleByUserId);
            return i ;
        }
        else
            return 0;
    }
}
