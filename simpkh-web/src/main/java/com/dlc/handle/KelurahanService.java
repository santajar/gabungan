package com.dlc.handle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import id.go.kemsos.simpkh.domain.references.repository.JpaKelurahanRepository;

@Service
public class KelurahanService {
	
	@Autowired
	private JpaKelurahanRepository jpaKelurahanRepository;

	public KelurahanService() {
		// TODO Auto-generated constructor stub
		super();
	}

}
