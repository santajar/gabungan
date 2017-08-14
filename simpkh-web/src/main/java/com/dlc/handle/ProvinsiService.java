package com.dlc.handle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import id.go.kemsos.simpkh.domain.references.repository.JpaPropinsiRepository;

@Service
public class ProvinsiService {

	@Autowired
	private JpaPropinsiRepository jpaPropinsiRepository;

	public ProvinsiService() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
