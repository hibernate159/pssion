package com.l.z.web.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.l.z.common.pojo.Demo;

@Controller
@RequestMapping(value = "/show/")
public class LoginController {

    @RequestMapping(value = "login.do", params = "uname", method = { RequestMethod.GET })
    public ModelAndView login(HttpSession redisSession, Demo demo) {
        ModelAndView mv = new ModelAndView();
        if (redisSession.getAttribute("user") != null) {
            mv.setViewName("redirect:/login.html");
            return mv;
        }
        // TODO 登录验证
        redisSession.setAttribute("user", demo);
        // TODO 登录成功后,记录sessionID
        String sessionId = redisSession.getId();
        mv.setViewName("redirect:/login.html");
        return mv;
    }

    @RequestMapping(value = "logout.do", method = { RequestMethod.GET })
    public ModelAndView logout(HttpSession redisSession) {
        if (redisSession != null) {
            redisSession.removeAttribute("user");
        }
        ModelAndView mv = new ModelAndView();
        mv.setViewName("redirect:/login.html");
        return mv;
    }
}
