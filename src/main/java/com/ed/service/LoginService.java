package com.ed.service;

import com.ed.pojo.User;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;


public interface LoginService {
    String checkLogin(User user, String verify, HttpServletRequest request);

    String selectRole();

    String confimPassword(String oldPass);

    int updatePassword(String newPass);
}
