package com.dlc.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.dlc.repository.UserRepository;
import com.dlc.service.SecurityService;
import com.dlc.service.UserService;

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

    @RequestMapping(value = "/")
	public ModelAndView index() {
		ModelAndView modelAndView = new ModelAndView();
		
			modelAndView.addObject("successMessage", "User has been registered successfully");
			modelAndView.addObject("user", new User());
			modelAndView.setViewName("index");
//			modelAndView.setView("index");
			
		
		return modelAndView;
	}

	@GetMapping("/home")
    public String home() {
        return "/home";
    }
	
	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public ModelAndView createNewUser(@Valid User user, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView();
		
			userService.save(user);
			modelAndView.addObject("successMessage", "User has been registered successfully");
			modelAndView.addObject("user", new User());
			modelAndView.setViewName("useradd");
			
		return modelAndView;
	}
	
	@RequestMapping(value = "/edituser", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView edituser(@Valid User user, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView();
		
			userService.save(user);
			modelAndView.addObject("successMessage", "User has been Update successfully");
	    	Iterable<User> users = this.userRepository.findAll();
	    	modelAndView.addObject("users", users);
			modelAndView.setViewName("userList");
			
		return modelAndView;
	}

    @GetMapping("/admin")
    public String admin() {
        return "/admin";
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
    
    @RequestMapping(value = "/useredit/{id}", method = RequestMethod.GET)
	public ModelAndView edit(User user,@PathVariable("id") Long id) {
		ModelAndView modelAndView = new ModelAndView();
		User userExists = userService.findByID(id);
		modelAndView.addObject("user", userExists);
		modelAndView.setViewName("useredit");
			
		
		return modelAndView;
	}
    
    @RequestMapping(value = "/userdelete/{id}", method = RequestMethod.GET)
	public ModelAndView delete(User user,@PathVariable("id") Long id) {
		ModelAndView modelAndView = new ModelAndView();
		User userExists = userService.findByID(id);
		userService.delete(userExists);
		modelAndView.addObject("successMessage", "User has been DELETE successfully");
		Iterable<User> users = this.userRepository.findAll();
    	modelAndView.addObject("users", users);
		modelAndView.setViewName("userList");
		
		return modelAndView;
	}

    @GetMapping("/403")
    public String error403() {
        return "/error/403";
    }

}