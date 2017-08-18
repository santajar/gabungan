package com.dlc.handle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import id.go.kemsos.simpkh.domain.references.repository.JpaKecamatanRepository;

@Service
public class KecamatanService {
	
	@Autowired
	private JpaKecamatanRepository jpaKecamatanRepository;

	public KecamatanService() {
		// TODO Auto-generated constructor stub
		super();
	}

}
