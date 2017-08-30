package com.dlc.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.dlc.repository.UserRepository;
import com.dlc.service.KabupatenServiceInterface;
import com.dlc.service.KecamatanServiceInterface;
import com.dlc.service.PropinsiServiceInterface;
import com.dlc.service.UserService;
import com.dlc.util.PageWrapper;

import id.go.kemsos.simpkh.domain.acl.User;
import id.go.kemsos.simpkh.domain.references.KabupatenEntity;
import id.go.kemsos.simpkh.domain.references.KecamatanEntity;
import id.go.kemsos.simpkh.domain.references.PropinsiEntity;

@Controller
public class UserController {

	@Autowired
	protected UserService userService;
	
	@Autowired
	PropinsiServiceInterface propinsiServiceInterface;
	
	@Autowired
	KecamatanServiceInterface kecamatanRepository;
	
	@Autowired
	KabupatenServiceInterface kabupatenServiceInterface;
	
	@Autowired
	KecamatanServiceInterface kecamatanServiceInterface;
    
    @Autowired
    private UserRepository userRepository;

	
	
//	public ModelAndView
	@GetMapping("/useradd")
	public ModelAndView useradd(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("user", new User());
		modelAndView.addObject("prop", new PropinsiEntity());
		modelAndView.addObject("allPropinsi", (ArrayList<PropinsiEntity>) propinsiServiceInterface.getAllPropinsi());
		modelAndView.addObject("kab", new KabupatenEntity());
		modelAndView.addObject("allKabupaten", (ArrayList<KabupatenEntity>) kabupatenServiceInterface.getAllKabupaten());
		modelAndView.addObject("allKecamatan", (ArrayList<KecamatanEntity>) kecamatanRepository.getAllKecamatan());
		modelAndView.addObject("kec", new KecamatanEntity());
		modelAndView.setViewName("user");
		return modelAndView;
	}
	
	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public ModelAndView createNewUser(@Valid User user, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView();
		
			userService.save(user);
			modelAndView.addObject("user", new User());
			modelAndView.setViewName("redirect:userlist");
			
		return modelAndView;
	}
	
	@RequestMapping(value = "/edituser", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView edituser(@Valid User user, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView();
		
			userService.save(user);
	    	Iterable<User> users = this.userRepository.findAll();
	    	modelAndView.addObject("users", users);
			modelAndView.setViewName("redirect:userlist");
			
		return modelAndView;
	}
	
	 @GetMapping("/userlist")
	    public ModelAndView userList(Pageable pageable) {
	    	ModelAndView modelAndView = new ModelAndView();

	    	Page<User> productPage = userService.findAll(pageable);
	        PageWrapper<User> page = new PageWrapper<User>(productPage, "/userlist");
	        
	        modelAndView.addObject("products", page.getContent());
	        modelAndView.addObject("page", page);
	        
	    	Iterable<User> users = this.userRepository.findAll();
	    	modelAndView.addObject("users", users);
	    	System.out.println(users.toString());
			modelAndView.setViewName("userList");
			return modelAndView;
	    }
	 
	 @RequestMapping(value = "/useredit/{id}", method = RequestMethod.GET)
		public ModelAndView edit(User user,@PathVariable("id") Long id) {
			ModelAndView modelAndView = new ModelAndView();
			modelAndView.addObject("prop", new PropinsiEntity());
			modelAndView.addObject("allPropinsi", (ArrayList<PropinsiEntity>) propinsiServiceInterface.getAllPropinsi());
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
			modelAndView.setViewName("redirect:../userlist");
			
			return modelAndView;
		}
	    
	    @RequestMapping(value="/getKabupatenValues", method = RequestMethod.GET)
	    public @ResponseBody
	    Map<String, String> getStateCityValues(@RequestParam("state") Integer state) {
	        Map<String, String> cityValues = new HashMap<>();

	        List<KabupatenEntity> cities = kabupatenServiceInterface.findById(state);

	        for(KabupatenEntity city : cities){
	            cityValues.put(String.valueOf(city.getKode()), city.getName());
	        }

	        return cityValues;  
	    }
	    
	    @RequestMapping(value="/getKecamatanValues", method = RequestMethod.GET)
	    public @ResponseBody
	    Map<String, String> getKecamatanValues(@RequestParam("state") Integer state) {
	        Map<String, String> cityValues = new HashMap<>();

	        List<KecamatanEntity> cities = kecamatanServiceInterface.findById(state);

	        for(KecamatanEntity city : cities){
	            cityValues.put(String.valueOf(city.getKode()), city.getName());
	        }

	        return cityValues;  
	    }
	    
	   
}
