package com.dlc.service;


import java.util.Collection;
<<<<<<< HEAD
import java.util.List;
=======
>>>>>>> 1cfa692fb81104205b06934495e2a542ccabc6b4

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
<<<<<<< HEAD
	public List<KabupatenEntity> findById(Integer kode) {
		// TODO Auto-generated method stub
//		kabupatenRepository.FindAllWithDescriptionQuery
		List<KabupatenEntity> list = kabupatenRepository.findByPropinsi_kode(kode);
		return list;
	}



	
=======
	public KabupatenEntity findById(Integer kode) {
		// TODO Auto-generated method stub
		return kabupatenRepository.findOne(kode);
	}
>>>>>>> 1cfa692fb81104205b06934495e2a542ccabc6b4
	

}
