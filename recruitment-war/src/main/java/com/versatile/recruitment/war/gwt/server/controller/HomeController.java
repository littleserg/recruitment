package com.versatile.recruitment.war.gwt.server.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author LittleSerg
 * @version 1.0
 */
@Controller
public class HomeController {

    @RequestMapping(method = RequestMethod.GET, value = "/home")
    public ModelAndView redirect() {
        ModelAndView model = new ModelAndView();
        return model;
    }

}
