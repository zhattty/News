package com.qiafan.web4j.qiafan.controller;

import com.qiafan.web4j.qiafan.bean.News;
import com.qiafan.web4j.qiafan.bean.User;
import com.qiafan.web4j.qiafan.bean.msg.Msg;
import com.qiafan.web4j.qiafan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

/**
 * Created by ZhangYao
 * Date 2019/4/10 Time 15:22
 */
@Controller
public class UserController {
    @Autowired
    UserService userService;
    @RequestMapping("reg")
    @ResponseBody
    public Msg register(@RequestParam("username") String username, @RequestParam("password") String password){
        Msg msg = new Msg();
        msg.setCode(1);
        Boolean isNameExist = userService.checkUserName(username);
        if (isNameExist){
            msg.setMsgname("用户名已存在");
            return msg;
        }
        User user = new User();
        user.setName(username);
        user.setPassword(password);
        int result = userService.insertUser(user);
        if (result == 1){
            msg.setCode(0);
        }
        return msg;
    }

    @RequestMapping("login")
    @ResponseBody
    public Msg login(@RequestParam("username") String username,
                     @RequestParam("password") String password,
                     HttpServletRequest request){
        Msg msg = new Msg();
        User user = userService.selectUserByNameAndPassword(username, password);
        if (user != null){
            msg.setCode(0);
        }else {
            msg.setCode(1);
            msg.setMsgname("用户名或密码错误");
        }
        HttpSession session = request.getSession();
        session.setAttribute("user",user);
        return msg;
    }


    @RequestMapping("logout")
    public String logout(HttpServletRequest request, Model model){
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        session.removeAttribute("user");
        String username = "";
        String password = "";
        if (user != null) {
            session.setAttribute("username",username);
            session.setAttribute("password",password);
        }

        return "redirect:/home";
    }

    @RequestMapping("user/addNews")
    public String addNews(@Valid News news, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {

        }
        return null;
    }

}
