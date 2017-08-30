package com.dlc.service;

import java.util.Collection;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dlc.repository.PendampingRepository;

import id.go.kemsos.simpkh.domain.kpm.PendampingEntity;

@Service
@Transactional
public class PendampingServiceImplementation implements PendampingServiceInterface {

	@Autowired
	protected PendampingRepository pendampingRepository;
	
	public PendampingServiceImplementation() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Collection<PendampingEntity> getAllpendamping() {
		// TODO Auto-generated method stub
		Iterable<PendampingEntity> itr = pendampingRepository.findAll();
		return (Collection<PendampingEntity>)itr;
	}

	
}
