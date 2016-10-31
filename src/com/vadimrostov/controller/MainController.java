package com.vadimrostov.controller;

import com.vadimrostov.domain.User;
import com.vadimrostov.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Vad on 31.10.2016.
 */

@Controller
public class MainController {
    ModelAndView modelAndView = new ModelAndView();


    @Autowired
    UserService userService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView main() {

        modelAndView.addObject("lalala", null);
        modelAndView.addObject("user", new User());

        modelAndView.setViewName("index");
        return modelAndView;
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ModelAndView login(User user, BindingResult bindingResult){

        String login=user.getLogin(), password=user.getPassword();

        if (userService.isValid(login, password)){
            modelAndView.addObject("lalala", "lalala");
        }

        return modelAndView;
    }


    @RequestMapping("/")
    public String home(){
        return "redirect:/index";
    }

}
