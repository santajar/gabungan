package com.dlc.handle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import id.go.kemsos.simpkh.domain.references.repository.JpaKabupatenRepository;

@Service
public class KabupatenService {

	
	@Autowired
	private JpaKabupatenRepository jpaKabupatenRepository;
	
	public KabupatenService() {
		// TODO Auto-generated constructor stub
		super();
	}

}
