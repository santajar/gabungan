package com.dlc.service;


import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dlc.repository.PropinsiRepository;

import id.go.kemsos.simpkh.domain.references.PropinsiEntity;


@Service
@Transactional
public class PropinsiServiceImplementation implements PropinsiServiceInterface{

	@Autowired
	protected PropinsiRepository propinsiRepository;

	
	
	@Override
	public Collection<PropinsiEntity> getAllPropinsi() {
		// TODO Auto-generated method stub
		Iterable<PropinsiEntity> itr = propinsiRepository.findAll();
		return (Collection<PropinsiEntity>)itr;
	}
	

}
