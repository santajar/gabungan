package com.dlc.service;


import java.util.Collection;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dlc.repository.PropinsiRepository;
import com.dlc.repository.TKPMRepository;

import id.go.kemsos.simpkh.domain.kpm.KpmResertifikasiEntity;
import id.go.kemsos.simpkh.domain.references.PropinsiEntity;


@Service
@Transactional
public class TKPMServiceImplementation implements TKPMServiceInterface{

	@Autowired
	protected TKPMRepository tkpmrepository;


	@Override
	public List<Object[]> findAll(Integer prov, Integer kab, Integer kec,
			String pdp,String stat) {
		// TODO Auto-generated method stub
		Iterable<Object[]> itr = tkpmrepository.getCustomCount(prov, kab, kec, pdp, stat);
		return (List<Object[]>) itr;
	}


	@Override
	public List<Object[]> findAll(Integer prov, Integer kab, Integer kec, String pdp) {
		// TODO Auto-generated method stub
		Iterable<Object[]> itr = tkpmrepository.getCustomCount(prov, kab, kec, pdp);
		return (List<Object[]>) itr;
	}

	
//	
//	@Override
//	public Collection<KpmResertifikasiEntity> getAll() {
//		// TODO Auto-generated method stub
//		Iterable<Object[]> itr = tkpmrepository.getCustomCount();
//		return (Collection<KpmResertifikasiEntity>)itr;
//	}



	
	

}
