package com.ed.service.impl;

import com.ed.mapper.UserMapper;
import com.ed.pojo.User;
import com.ed.service.LoginService;
import com.ed.utils.EncryptionUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private UserMapper userMapper;


    @Override
    public String checkLogin(User user,String verify) {
        Subject s = SecurityUtils.getSubject();
        String code = (String) s.getSession().getAttribute("code");
        if(verify.equals(code)) {
            //UsernamePasswordToken 令牌类  稍后会把保存在里面账号密码和shiro的身份和凭证比对
            UsernamePasswordToken upt = new UsernamePasswordToken(user.getUserSno(), user.getUserPassword());
            try {
                //进行认证(因为我们写了自定义的realm类，所以会自动到realm类里面去认证)
                s.login(upt);
                return "success";
            } catch (AuthenticationException e) {
                //登录失败
                return "error";
            }
        }else {
            return "false";
        }

    }

    @Override
    public String selectRole() {
        Subject subject = SecurityUtils.getSubject();
        User user = (User) subject.getSession().getAttribute("user");
       String role = userMapper.selectRole(user.getUserSno());
        return role;
    }

    @Override
    public String confimPassword(String oldPass) {
        User user = (User) SecurityUtils.getSubject().getSession().getAttribute("user");
        SimpleHash encryption = EncryptionUtil.encryption(user.getUserSno(), oldPass);
        Map<String,String> param = new HashMap<>();
        param.put("encryption",encryption.toString());
        param.put("userSno",user.getUserSno());
        String db_password = userMapper.confimPassword(param);
        if(db_password!=null){
            return "true";
        }else {
            return "false";
        }

    }

    @Override
    public int updatePassword(String newPass) {
        User user = (User) SecurityUtils.getSubject().getSession().getAttribute("user");
        SimpleHash encryption = EncryptionUtil.encryption(user.getUserSno(), newPass);
        Map<String,String> param = new HashMap<>();
        param.put("newPass",encryption.toString());
        param.put("userSno",user.getUserSno());
        return userMapper.updatePassword(param);
    }
}
