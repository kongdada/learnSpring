package com.kaka.controller;

import com.kaka.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

/**
 * @author konglinghui
 * @date 2018/12/19
 */
@Controller
@RequestMapping("/session")
public class SessionController {

    // http://localhost:8080/kaka/session/set
    @RequestMapping("/set")
    public ModelAndView localsessionAttributes(HttpSession session) {
        session.setAttribute("currentUser", new User("9", "竹", "女"));
        ModelAndView mav = new ModelAndView("session/set");
        return mav;
    }

    /**
     * 获取session中的user对象
     *
     * @param session
     * @return
     */
    @RequestMapping("get")
    public ModelAndView sessionAttributesage(HttpSession session) {
        User user = (User) session.getAttribute("currentUser");
        ModelAndView mav = new ModelAndView("session/get");
        mav.addObject("user", user);
        return mav;
    }
}
