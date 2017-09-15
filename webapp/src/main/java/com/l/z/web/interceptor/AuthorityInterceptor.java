package com.l.z.web.interceptor;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.l.z.common.cache.DemoCache;

public class AuthorityInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private DemoCache demoCache;

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
        demoCache.testCache();
        // TODO 权限设置
    }

}
