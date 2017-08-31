package com.dlc.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.dlc.repository.TKPMRepository;
import com.dlc.service.KabupatenServiceInterface;
import com.dlc.service.KecamatanServiceInterface;
import com.dlc.service.PendampingServiceInterface;
import com.dlc.service.PropinsiServiceInterface;
import com.dlc.service.TKPMServiceInterface;
import com.dlc.service.UserService;
import com.dlc.util.HibernateUtil;

import id.go.kemsos.simpkh.domain.acl.User;
import id.go.kemsos.simpkh.domain.kpm.KpmResertifikasiEntity;
import id.go.kemsos.simpkh.domain.kpm.PendampingEntity;
import id.go.kemsos.simpkh.domain.references.KabupatenEntity;
import id.go.kemsos.simpkh.domain.references.KecamatanEntity;
import id.go.kemsos.simpkh.domain.references.PropinsiEntity;

@Controller
public class ExportController {
	
	@Autowired
	protected UserService userService;
	
	@Autowired
	PropinsiServiceInterface propinsiServiceInterface;
	
	@Autowired
	PendampingServiceInterface pendampingServiceInterface;
	
	@Autowired
	KecamatanServiceInterface kecamatanRepository;
	
	@Autowired
	KabupatenServiceInterface kabupatenServiceInterface;
	
	@Autowired
	KecamatanServiceInterface kecamatanServiceInterface;
    
	@Autowired
	TKPMServiceInterface tkpmservice;
	
	@GetMapping("/export")
	public ModelAndView export(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("user", new User());
		modelAndView.addObject("prop", new PropinsiEntity());
		modelAndView.addObject("allPropinsi", (ArrayList<PropinsiEntity>) propinsiServiceInterface.getAllPropinsi());
		modelAndView.addObject("kab", new KabupatenEntity());
		modelAndView.addObject("allKabupaten", (ArrayList<KabupatenEntity>) kabupatenServiceInterface.getAllKabupaten());
		modelAndView.addObject("allKecamatan", (ArrayList<KecamatanEntity>) kecamatanRepository.getAllKecamatan());
		modelAndView.addObject("kec", new KecamatanEntity());
//		modelAndView.addObject("allPendamping", (ArrayList<PendampingEntity>) pendampingServiceInterface.getAllpendamping());
//		modelAndView.addObject("pend", new PendampingEntity());
		modelAndView.setViewName("exportresertifikasi");
		return modelAndView;
	}
	@GetMapping("/getExport")
	public ModelAndView getExportdata(){
		ModelAndView modelAndView = new ModelAndView();
		List<Object[]> list = tkpmservice.findAll();
		for(Object[] arr : list){
			System.out.println(Arrays.asList(arr));
		}
		modelAndView.addObject("list", list);
		modelAndView.setViewName("exportresertifikasi :: resultsList");
		return modelAndView;
	}
	
	@GetMapping(value = "/export/export.csv")
	public void exportCSV(HttpServletResponse response) {         
	    try {
	    	response.setContentType("text/plain; charset=utf-8");
			response.getWriter().print("a,b,c\n1,2,3\n3,4,5");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
