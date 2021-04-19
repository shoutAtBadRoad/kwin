package com.kwin.db.test.user.controller;


import com.kwin.db.test.user.entity.User;
import com.kwin.db.test.user.mapper.UserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {

    Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    UserMapper userMapper;

    @ResponseBody
    @PostMapping("/login")
    public Map<String, Object> Login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Map<String,Object> map = new HashMap<>();
//        String path = "https://www.ytofreight.xyz/datav/#/login";
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        log.info("username:"+username);
        if(username.equals("admin") && password.equals("123")){
            map.put("msg",1);
            map.put("token","Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1aWQiOjUwMCwicmlkIjowLCJpYXQiOjE1MTI1NDQyOTksImV4cCI6MTUxMjYzMDY5OX0.eGrsrvwHm-tPsO9r_pxHIQ5i5L1kX9RX444uwnRGaIM");
//            RequestDispatcher requestDispatcher=req.getRequestDispatcher(path);
//            session.setAttribute("user",username+"-yes");
//            requestDispatcher.forward(req,resp);
        }else {
            map.put("msg",0);
//            RequestDispatcher requestDispatcher=req.getRequestDispatcher(path);
//            requestDispatcher.forward(req,resp);
//            return "login";
        }
        return map;
//        String userType = req.getParameter("userType");
//        String remember = req.getParameter("remember");

//        if(userType.equals("admin")) {
//            Admin admin = userMapper.getAdmin(userName, password);
//            if (admin != null) {
//                map.put("admin", admin);
//                session.setAttribute("currentUserType", "admin");
//                session.setAttribute("currentUser", admin);  //登录成功则往session域中写入用户信息
//                if("remember-me".equals(remember)) {
//                    rememberMe(userName, password, userType,resp);
//                } else {
//                    deleteCookie(userName, req, resp);
//                }
//                log.info("登录成功");
//                return "redirect:http://localhost:8080/Alpha/kesheng/index.html";
//            } else {
//                log.info("登陆失败");
//                req.setAttribute("admin", admin);
//                req.setAttribute("error", "\t用户名或密码错误");//登录失败则返回登陆页面，在request域中写入error键值对
//                return "forward:http://localhost:8080/Alpha/login.jsp";
//            }
//        }else {
//            SystemManager systemManager = userMapper.getSystemManager(userName, password);
//            if (systemManager != null) {
//                map.put("systemManager", systemManager);
//                session.setAttribute("currentUserType", "systemManager");
//                session.setAttribute("currentUser", systemManager);//登录成功则往session域中写入用户信息
//                if("remember-me".equals(remember)) {
//                    rememberMe(userName, password, userType,resp);
//                } else {
//                    deleteCookie(userName, req, resp);
//                }
//                log.info("登录成功");
//                return "redirect:http://localhost:8080/Alpha/kesheng/index.html";
//            } else {
//                log.info("登陆失败");
//                map.put("user", systemManager);
//                map.put("error", "\t用户名或密码错误");//登录失败则返回登陆页面，在request域中写入error键值对
//                return "redirect:http://localhost:8080/Alpha/login.jsp";
//            }
//        }
    }



    @ResponseBody
    @RequestMapping("/test")
    public User test(){
        User user = new User("sxy","123");
        User out = userMapper.getUser("sxy","123");
        return out;
    }




    private void rememberMe(String userName, String password, String userType, HttpServletResponse response) {
        Cookie user = new Cookie("sysuser", userName+"-"+password+"-"+userType+"-"+"yes");
        user.setMaxAge(1*60*60*24*7);
        response.addCookie(user);
    }
    private void deleteCookie(String userName, HttpServletRequest request, HttpServletResponse response) {
        Cookie[] cookies=request.getCookies();
        for(int i=0;cookies!=null && i<cookies.length;i++){
            if(cookies[i].getName().equals("sysuser")){
                if(userName.equals(userName=cookies[i].getValue().split("-")[0])) {
                    Cookie cookie = new Cookie(cookies[i].getName(), null);
                    cookie.setMaxAge(0);
                    response.addCookie(cookie);
                    break;
                }
            }
        }
    }

}
