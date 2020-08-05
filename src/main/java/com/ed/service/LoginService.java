package com.ed.service;

import com.ed.pojo.User;
import org.springframework.stereotype.Service;


public interface LoginService {
    String checkLogin(User user,String verify);

    String selectRole();

    String confimPassword(String oldPass);

    int updatePassword(String newPass);
}
