package com.l.z.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.l.z.common.pojo.Demo;

@Controller
@RequestMapping(value = "/show/")
public class LoginController {

    @RequestMapping(value = "login.do", method = { RequestMethod.GET })
    public ModelAndView login(HttpSession redisSession, Demo demo) {
        redisSession.setAttribute("user", demo);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("redirect:/login.html");
        return mv;
    }

    @RequestMapping(value = "logout.do", method = { RequestMethod.GET })
    public ModelAndView logout(HttpSession redisSession) {
        redisSession.removeAttribute("user");
        ModelAndView mv = new ModelAndView();
        mv.setViewName("redirect:/login.html");
        return mv;
    }
}
