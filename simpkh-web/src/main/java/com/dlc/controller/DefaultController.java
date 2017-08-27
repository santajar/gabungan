package com.dlc.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.dlc.service.SecurityService;

import id.go.kemsos.simpkh.domain.acl.User;

@RestController
@Controller
public class DefaultController {

    @Autowired
    private SecurityService securityService;    

    @RequestMapping(value = "/") 
	public ModelAndView index() {
		ModelAndView modelAndView = new ModelAndView();
		
			modelAndView.addObject("successMessage", "User has been registered successfully");
			modelAndView.addObject("user", new User());
			modelAndView.setViewName("index");
			
		
		return modelAndView;
	}

    @RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView login(@ModelAttribute("user") User user, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView();
		securityService.autologin(user.getUsername(), user.getPassword());
		if (bindingResult.hasErrors()) {
//			modelAndView.addObject("successMessage", "User has been registered successfully");
			modelAndView.setViewName("index");
		} else {
			
			modelAndView.addObject("successMessage", "User has been registered successfully");
			modelAndView.addObject("user", new User());
			modelAndView.setViewName("home");
			
		}
		return modelAndView;
	}
    
    @GetMapping("/403")
    public String error403() {
        return "/error/403";
    }

}