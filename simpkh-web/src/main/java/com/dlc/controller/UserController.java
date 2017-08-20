package com.dlc.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.dlc.service.KabupatenServiceInterface;
import com.dlc.service.PropinsiServiceInterface;
import com.dlc.service.UserService;

import id.go.kemsos.simpkh.domain.acl.User;
import id.go.kemsos.simpkh.domain.references.KabupatenEntity;
import id.go.kemsos.simpkh.domain.references.PropinsiEntity;

@Controller
public class UserController {

	@Autowired
	protected UserService userService;
	
	@Autowired
	PropinsiServiceInterface propinsiServiceInterface;
	
	@Autowired
	KabupatenServiceInterface kabupatenServiceInterface;
	
	
//	public ModelAndView
	@GetMapping("/useradd")
	public ModelAndView useradd(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("user", new User());
		modelAndView.addObject("prop", new PropinsiEntity());
		modelAndView.addObject("allPropinsi", (ArrayList<PropinsiEntity>) propinsiServiceInterface.getAllPropinsi());
		modelAndView.addObject("kab", new KabupatenEntity());
		modelAndView.addObject("allKabupaten", (ArrayList<KabupatenEntity>) kabupatenServiceInterface.getAllKabupaten());
		modelAndView.setViewName("user");
		return modelAndView;
	}
}
