package com.SpringbootHtmlThymeleaf.HTMLwithThymeleaf.controller;

import com.SpringbootHtmlThymeleaf.HTMLwithThymeleaf.entity.User;
import com.SpringbootHtmlThymeleaf.HTMLwithThymeleaf.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/addUser")
    public ModelAndView createUserView() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("add-user");
        mav.addObject("user", new User());
        mav.addObject("allStats", getStats());
        mav.addObject("allHobbies", getHobbies());
        return mav;
    }
    @PostMapping("/addUser")
    public ModelAndView createUser(@Valid User user, BindingResult result) {
        ModelAndView mav = new ModelAndView();
        if(result.hasErrors()) {
            mav.setViewName("user-creation");
            mav.addObject("user", user);
            mav.addObject("allStats", getStats());
            mav.addObject("allHobbies", getHobbies());
            return mav;
        }
        userService.addUser(user);
        mav.addObject("allUsers", userService.getAllUserArticles());
        mav.setViewName("index");
        return mav;
    }
    private List<String> getStats() {
        List<String> listS = new ArrayList<>();
        listS.add("Single");
        listS.add("Married");
        listS.add("Divorce");
        return listS;
    }
    private List<String> getHobbies() {
        List<String> listH = new ArrayList<>();
        listH.add("Painting");
        listH.add("Reading");
        listH.add("Swimming");
        return listH;
    }
}
