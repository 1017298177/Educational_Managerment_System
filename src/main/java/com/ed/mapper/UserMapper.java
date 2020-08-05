package com.ed.mapper;

import com.ed.pojo.User;
import org.apache.shiro.crypto.hash.SimpleHash;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    User queryPersonByPersonName(String userSno);

    String selectRole(String userSno);

    String confimPassword(Map<String,String> param);

    int updatePassword(Map<String, String> param);

    User selectstudentmakeup(String userSno);

    User userbook(String userSno);

    List<User> queryUserByPage(User user);

    List<User> queryAllTeacher(User user);

}