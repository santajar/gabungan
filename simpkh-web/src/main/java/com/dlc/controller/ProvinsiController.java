package com.dlc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProvinsiController {

	@GetMapping("/prov")
	public String getProv(){
		return null;
	}
}
