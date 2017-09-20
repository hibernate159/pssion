package com.l.z.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.l.z.common.cache.DemoCache;

@Controller
public abstract class AbstractBaseController {

    @Autowired
    private DemoCache demoCache;

    @ExceptionHandler
    protected ModelAndView exp(Exception ex) {
        System.out.println(ex);
        ModelAndView mv = new ModelAndView("redirect:/error.html");
        // mv.addObject("ex", ex);

        // 根据不同错误转向不同页面
        // if (ex instanceof SQLException) {
        // mv.addObject("", ex);
        // } else {
        // mv.addObject("", ex);
        // }
        return mv;
    }

    @RequestMapping(value = "/uploadFile.do", method = { RequestMethod.POST })
    protected ModelAndView uploadFile(@RequestParam("formFile") MultipartFile upFile) {
        ModelAndView mv = new ModelAndView("redirect:/error.html");
        upFile.getOriginalFilename();
        return mv;
    }

}
