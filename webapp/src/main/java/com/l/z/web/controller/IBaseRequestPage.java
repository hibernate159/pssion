package com.l.z.web.controller;

import org.springframework.web.servlet.ModelAndView;

public interface IBaseRequestPage<T> {

    ModelAndView screenPageHtml(String type, T params);

    ModelAndView doFormToAction(String type, T params);

    String screenPageCount(String type, T params);
}
