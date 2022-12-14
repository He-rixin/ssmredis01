package com.test.controller;

import com.sun.deploy.net.HttpResponse;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.session.HttpServletSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author herixin
 * @create 2022-12-13 20:35
 */
@Controller
@RequestMapping("/index")
public class IndexController {
    @RequestMapping("/toMain")
    public String toMain() {
        return "main";
    }
@RequestMapping("/")
public String login() {
    return "login";
}
    @RequestMapping("/toLogin")
    public String toLogin(HttpSession session, String username, String password) {
        System.out.println("username = " + username);
        //4.获取主体
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        try {
            subject.login(token);
        } catch (IncorrectCredentialsException e) {
            e.printStackTrace();
            session.setAttribute("message", "密码错误");
            return "login";
        } catch (UnknownAccountException e) {
            session.setAttribute("message", "账号不存在");
            return "login";
        }
        session.setAttribute("username", username);
        return "main";
    }
    @RequestMapping("/update")
    @RequiresRoles({"admin","user"})
    public String update() {
        return "";
    }

}
