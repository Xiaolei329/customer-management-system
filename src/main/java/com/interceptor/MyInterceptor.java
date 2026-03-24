/**
 * @Title NewSSMBOOT
 * @Package com.interceptor
 * @author Penghui Lei
 * @date 2024/12/29
 * @version 11.0
 */
package com.interceptor;

import com.entity.UserEntity;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class MyInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        检查信息
        String url = request.getRequestURI();
        if(url.contains("/login") || url.contains("/getVerifyCode")){
            return true;
        }

        System.out.println("拦截器检查");

//        检查session
        HttpSession httpSession = request.getSession();
        UserEntity loginUser = (UserEntity)httpSession.getAttribute("LOGIN_USER");
        if(loginUser != null){
            return true;
        }

//        重定向登录界面
        request.setAttribute("msg", "您还没有登录！");
        request.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(request, response);
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
    }
}
