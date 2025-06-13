package com.example.book.interceptor;

import com.example.book.constant.Constants;
import com.example.book.model.Result;
import com.example.book.model.UserInfo;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
@Slf4j
@Component
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("preHandle执行前");
        //true放行
        //false拦截
        HttpSession session = request.getSession(false);
        if (!checkUser(session)){
            response.setContentType("text/html;charset=utf-8");
            response.setStatus(401);
            String msg = "用户未登录";
            response.getOutputStream().write(msg.getBytes("UTF-8"));
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.info("postHandle..........");

    }
    public boolean checkUser(HttpSession session){

        if (session==null||session.getAttribute(Constants.SESSION_USER_KEY)==null){
            log.warn("用户未登录");
            return false;
        }
        UserInfo userInfo = (UserInfo) session.getAttribute(Constants.SESSION_USER_KEY);
        if (userInfo==null||userInfo.getId()<=0){
            log.warn("用户未登录");
            return false;
        }
        log.info("用户登录");
        return true;
    }

//    @Override
//    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
//        log.info("afterCompletion..........");
//
//    }
}
