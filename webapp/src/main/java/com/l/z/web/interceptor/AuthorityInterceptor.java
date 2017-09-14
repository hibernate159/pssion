package com.l.z.web.interceptor;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AuthorityInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;
    
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                    ModelAndView modelAndView) throws Exception {
        if (modelAndView == null) {
            return;
        }
        
        // HttpSession session = request.getSession();
        // Object attribute = session.getAttribute("user");
        // if (attribute == null) {
        // return;
        // }
        System.out.println(modelAndView.getViewName());
        modelAndView.addObject("userStr", "供应商[100148]");

        // TODO 权限设置
    }

}
