package com.kaka.controller;

import com.kaka.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

/**
 * @author konglinghui
 * @date 2018/12/20
 */
@Controller
@SessionAttributes(value = "key")
public class SessionAnnotation {

    @RequestMapping("/sessionAnnote/set")
    public ModelAndView setSessionInfo() {
        ModelAndView mav = new ModelAndView("personInfo");
        mav.addObject("key", new User("10", "pipi", "男"));
        mav.setViewName("/session/set");
        return mav;
    }

    @RequestMapping("/sessionAnnote/get")
    public ModelAndView getSessonInfo(HttpSession session) {
        User user = (User) session.getAttribute("key");
        ModelAndView mav = new ModelAndView("personInfo");
        mav.addObject("user", user);
        mav.setViewName("/session/get");
        return mav;
    }
}
