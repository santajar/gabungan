package com.dlc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DefaultController {

	@RequestMapping("/")
    public String index() {
    	System.out.println("tes");
        return "index";
    }

    @RequestMapping(value ="home",method = RequestMethod.POST)
    public String home() {
        return "home";
    }
//
//    @GetMapping("/admin")
//    public String admin() {
//        return "/admin";
//    }
//
//    @GetMapping("/user")
//    public String user() {
//        return "/user";
//    }
//
//    @GetMapping("/about")
//    public String about() {
//        return "/about";
//    }
//
    @RequestMapping(value ="/login",method = RequestMethod.POST)
    public String login() {
    	System.out.println("masuk");
        return "home";
    }
//
//    @GetMapping("/403")
//    public String error403() {
//        return "/error/403";
//    }

}