package com.ed.controller;

import com.ed.pojo.User;
import com.ed.service.LoginService;
import com.ed.utils.ImageUtil;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

@Controller
@RequestMapping("loginController")
public class LoginController {
    @Autowired
    private LoginService loginService;


    @RequestMapping("welcome.do")
    public String welcome(Model model){
        model.addAttribute("date",(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())));
        model.addAttribute("user",(User)SecurityUtils.getSubject().getSession().getAttribute("user"));
        return "login/welcome";
    }

    @RequestMapping("imgCode.do")
        public String getCode(HttpServletRequest request, HttpServletResponse response) throws Exception{
            response.setContentType("image/jpeg");
            //禁止图像缓存
            response.setHeader("Pragma","no-cache");
            response.setHeader("Cache-Control", "no-cache");
            response.setDateHeader("Expires", 0);
            HttpSession session = request.getSession();
            ImageUtil imageUtil = new ImageUtil(120, 40, 5,30);
            session.setAttribute("code", imageUtil.getCode());
            imageUtil.write(response.getOutputStream());
            return null;
    }


    @RequestMapping("index.do")
    public String index(Model model) {
        String role = loginService.selectRole();
        model.addAttribute("role",role);
        model.addAttribute("user",(User)SecurityUtils.getSubject().getSession().getAttribute("user"));
        return "login/index";
    }

    @RequestMapping("noLogin.do")
    public String noLogin() {
        return "login/login";
    }

    @RequestMapping("checkLogin.ajax")
    @ResponseBody
    public String checkLogin(User user,String verify) {
        String check = loginService.checkLogin(user,verify);
        return check;
    }
    @RequestMapping("logout.do")
    public String logout(){
        SecurityUtils.getSubject().logout();
        return "redirect:/loginController/noLogin.do";
    }

    @RequestMapping("login.do")
    public String language(@RequestParam("locale") String locale, HttpServletRequest request, HttpServletResponse response){
            if (locale.equals("zh")) {
                Locale locale1 = new Locale("zh", "CN");
                (new CookieLocaleResolver()).setLocale(request, response, locale1);
            } else if (locale.equals("en")) {
                Locale locale1 = new Locale("en", "US");
                (new CookieLocaleResolver()).setLocale(request, response, locale1);
            } else
                (new CookieLocaleResolver()).setLocale(request, response, LocaleContextHolder.getLocale());
        return "login/login";
    }

    @RequestMapping("updatePasswordPage.do")
    public String updatePasswordPage(){
        return "login/updatePasswordPage";
    }

    @RequestMapping("confimPassword.ajax")
    @ResponseBody
    public String confimPassword(String oldPass){
       String flag = loginService.confimPassword(oldPass);
        return flag;
    }

    @RequestMapping("updatePassword.ajax")
    @ResponseBody
    public int  updatePassword(String newPass){
        return  loginService.updatePassword(newPass);
    }



}
