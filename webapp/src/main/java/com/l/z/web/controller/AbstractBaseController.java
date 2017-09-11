package com.l.z.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@Controller
public abstract class AbstractBaseController {

	@ExceptionHandler
    protected ModelAndView exp(Exception ex) {
		ModelAndView mv = new ModelAndView("redirect:/error.html");
//		mv.addObject("ex", ex);

        // 根据不同错误转向不同页面
//        if (ex instanceof SQLException) {
//        	mv.addObject("", ex);
//        } else {
//        	mv.addObject("", ex);
//        }
        return mv;
    }
	
	
}
