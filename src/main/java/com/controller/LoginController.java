/**
 * @Title NewSSMBOOT
 * @Package com.controller
 * @author Penghui Lei
 * @date 2024/12/29
 * @version 11.0
 */
package com.controller;

import com.entity.UserEntity;
import com.service.UserService;
import com.vo.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
public class LoginController {
    @Autowired
    private UserService userService;

//    获取验证码
    @RequestMapping("/getVerifyCode")
    public void getVerifyCode(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1. 生成验证码图片 并返回图片；
        //2. 将验证码图片的字符串保存在httpSession，属性名："VerifyCode"
        com.util.VerifyCodeUtils.outputVerifyCode(request, response);
    }

//    管理员登录
    @PostMapping("/login")
    public String login(UserInfo user, Model model, HttpSession httpSession) {
        String userName = user.getUserName();
        String password = user.getPassword();
        String verifyCode = user.getVerifyCode();
        System.out.println("userName:"+userName +
                " password:" + password +
                " verifyCode:" + verifyCode);
//        检查验证码
        String sessionCode = (String) httpSession.getAttribute("VerifyCode");
        httpSession.removeAttribute("VerifyCode");
        if(verifyCode==null || !verifyCode.equalsIgnoreCase(sessionCode) ){
//            验证码输入错误
            model.addAttribute("msg", "验证码错误，请重新输入！");
            return "login";
        }

//        判断密码正误
        UserEntity loginUser = userService.findByUserName(user.getUserName());
        System.out.println(loginUser);
        if(loginUser != null && password.equals(loginUser.getUser_password())){
//            用户信息
            httpSession.setAttribute("LOGIN_USER", loginUser);
            return "redirect:/index";
        }
//        用户名或密码错误
        model.addAttribute("msg", "用户名或密码错误，请重新登录！");
        return "login";
    }

//    退出系统，清除session
    @RequestMapping("/logout")
    public String logout(HttpSession httpSession) {
        httpSession.invalidate();
        return "login";
    }

//    主页
    @RequestMapping("/index")
    public String index() {
        return "index";
    }
}
