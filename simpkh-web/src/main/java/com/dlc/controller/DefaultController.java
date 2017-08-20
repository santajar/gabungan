package com.dlc.controller;

import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.dlc.repository.RoleRepository;
import com.dlc.repository.UserRepository;
import com.dlc.service.SecurityService;
import com.dlc.service.UserService;

import id.go.kemsos.simpkh.domain.acl.Role;
import id.go.kemsos.simpkh.domain.acl.User;

@RestController
@Controller
public class DefaultController {
	
	@Autowired
    private UserService userService;

    @Autowired
    private SecurityService securityService;
    
    @Autowired
    private UserRepository userRepository;


    @RequestMapping(value = "/", method = RequestMethod.GET) 
    public ModelAndView displayLogin() { 
    	ModelAndView modelAndView = new ModelAndView();
    	modelAndView.setViewName("index");
//    	modelAndView.addObject("user", new User());
        return modelAndView; 
    }


	@GetMapping("/home")
    public String home() {
        return "/home";
    }
	
	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public ModelAndView createNewUser(@ModelAttribute("userForm") User userForm, BindingResult bindingResult, 
	  		  Model model) {
		ModelAndView modelAndView = new ModelAndView();
		userForm.setEnabled(true);
		userForm.setAccountExpired(false);
		userForm.setCredentialsExpired(true);
			userService.save(userForm);
			modelAndView.addObject("successMessage", "User has been registered successfully");
			modelAndView.addObject("user", new User());
			modelAndView.setViewName("useradd");
			
		
		return modelAndView;
	}

    @GetMapping("/admin")
    public String admin() {
        return "/admin";
    }

<<<<<<< HEAD
    @GetMapping("/useradd")
    public ModelAndView user() {
    	ModelAndView modelAndView = new ModelAndView();		
		modelAndView.setViewName("useradd");
		return modelAndView;
    }
    
    @GetMapping("/userlist")
    public ModelAndView userList() {
    	ModelAndView modelAndView = new ModelAndView();
//		modelAndView.addObject("user", new User());
    	Iterable<User> users = this.userRepository.findAll();
    	modelAndView.addObject("users", users);
		modelAndView.setViewName("userList");
		return modelAndView;
    }


    @RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView login(@ModelAttribute("userForm") User userForm, BindingResult bindingResult, 
	  		  Model model) {
		ModelAndView modelAndView = new ModelAndView();
//		User userExists = userService.findByUsername(userForm.getUsername());
		securityService.autologin(userForm.getUsername(),userForm.getPassword());
		System.out.println(securityService.findLoggedInUsername());
		System.out.println(userForm.getFullName());

		if (bindingResult.hasErrors()) {
			modelAndView.setViewName("index");
		} else {
			
			modelAndView.addObject("successMessage", "User has been registered successfully");
//			modelAndView.addObject("user", new User());
			modelAndView.setViewName("home");
			
		}
		return modelAndView;
	}
    
    

    @GetMapping("/403")
    public String error403() {
        return "/error/403";
    }

}