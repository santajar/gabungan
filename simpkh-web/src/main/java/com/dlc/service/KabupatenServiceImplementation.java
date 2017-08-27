package com.dlc.service;


import java.util.Collection;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dlc.repository.KabupatenRepository;
import com.dlc.repository.PropinsiRepository;

import id.go.kemsos.simpkh.domain.references.KabupatenEntity;
import id.go.kemsos.simpkh.domain.references.PropinsiEntity;


@Service
@Transactional
public class KabupatenServiceImplementation implements KabupatenServiceInterface{

	@Autowired
	protected KabupatenRepository kabupatenRepository;

	
	
	@Override
	public Collection<KabupatenEntity> getAllKabupaten() {
		// TODO Auto-generated method stub
		Iterable<KabupatenEntity> itr = kabupatenRepository.findAll();
		return (Collection<KabupatenEntity>)itr;
	}



	@Override
	public List<KabupatenEntity> findById(Integer kode) {
		// TODO Auto-generated method stub
//		kabupatenRepository.FindAllWithDescriptionQuery
		List<KabupatenEntity> list = kabupatenRepository.findByPropinsi_kode(kode);
		return list;
	}



	
	

}
