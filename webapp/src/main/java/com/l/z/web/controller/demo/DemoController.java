package com.l.z.web.controller.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.l.z.common.pojo.Demo;
import com.l.z.web.controller.AbstractBaseController;

@Controller
@RequestMapping(value = "/demo/")
public class DemoController extends AbstractBaseController {

	// @Autowired

	@RequestMapping(value = "demo.htm", method = { RequestMethod.GET })
	public String htmlDemo() {
		throw new NumberFormatException(); 
	}

	@RequestMapping(value = "demo{id}.htm", method = { RequestMethod.GET })
	public ModelAndView htmlDemo2(@PathVariable(value="id") String id) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("name", id);
		mv.setViewName("demo/mv");
		return mv;
	}

	@ResponseBody
	@RequestMapping(value = "jd.json", method = { RequestMethod.GET })
	public String jsonDemo2() {
		return "{username: \"Josh\", password: \"Passw0rd\"}";
	}

	@RequestMapping(value = "att.htm", method = { RequestMethod.GET })
	public ModelAndView vmDemo3(@ModelAttribute Demo d) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("name", 23);
		mv.addObject("age", 23);
		mv.setViewName("demo/mv");
		return mv;
	}
}
