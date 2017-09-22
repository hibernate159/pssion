package com.l.z.web.controller.demo;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.l.z.common.annotations.CsrfBindSwitch;
import com.l.z.common.biz.IDemoService;
import com.l.z.common.pojo.vo.DemoVO;
import com.l.z.web.controller.AbstractBaseController;
import com.l.z.web.controller.IBaseRequestPage;

@Controller
@RequestMapping(value = "/demo/")
public class DemoController extends AbstractBaseController implements IBaseRequestPage<DemoVO> {

    private final String BASE_VIEW = "demo/";

    @Autowired
    private IDemoService demoServiceImpl;

    @Override
    @RequestMapping(value = "rp_{type}.htm")
    public ModelAndView screenPageHtml(@PathVariable(value = "type") String type,
                    @ModelAttribute("returnPage") DemoVO params) {
        log.warn("demo test log");
        ModelAndView mv = new ModelAndView();
        if (StringUtils.equals("", type)) {
            demoServiceImpl.testDemo("");
        }
        demoServiceImpl.testDemo("");
        mv.setViewName(BASE_VIEW + type);
        return mv;
    }

    @Override
    @ResponseBody
    @RequestMapping(value = "c_{type}.json", method = { RequestMethod.GET })
    public String screenPageCount(@PathVariable(value = "type") String type, DemoVO params) {
        // TODO Auto-generated method stub
        return "{username: \"Josh\", password: \"Passw0rd\"}";
    }

    @Override
    @CsrfBindSwitch
    @RequestMapping(value = "f_{action}.do", params = "_csrf_token", method = { RequestMethod.POST })
    public ModelAndView doFormToAction(@PathVariable(value = "action") String action, DemoVO params) {
        ModelAndView mv = new ModelAndView("error");
        if (StringUtils.equals("", action)) {
            demoServiceImpl.testDemo("");
        }
        return mv;
    }
}
