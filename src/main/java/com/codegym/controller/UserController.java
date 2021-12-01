package com.codegym.controller;

import com.codegym.model.User;
import com.codegym.service.IUserService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class UserController {

    @Autowired
    private IUserService userService;

    @GetMapping("/users")
    public ModelAndView show(){
        Iterable<User> user=userService.findAll();
        ModelAndView modelAndView=new ModelAndView("/show");
        modelAndView.addObject("users",user);
        return modelAndView;
    }

    @RequestMapping("/create")
    public ModelAndView createForm(){
        ModelAndView modelAndView=new ModelAndView("/create");
        modelAndView.addObject("user",new User());
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView create(@Valid @ModelAttribute User user, BindingResult bindingResult, RedirectAttributes redirectAttributes){
        new User().validate(user,bindingResult);
        if(bindingResult.hasFieldErrors()){
            return new ModelAndView("/create");
        }
        userService.save(user);
        ModelAndView modelAndView=new ModelAndView("redirect:/users");
        return modelAndView;
    }
}
