package com.dlc.service;

import java.util.Collection;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dlc.repository.KecamatanRepository;

import id.go.kemsos.simpkh.domain.references.KecamatanEntity;

@Service
@Transactional
public class KecamatanServiceImplementation implements KecamatanServiceInterface{

	@Autowired
	protected KecamatanRepository kecamatanRepository;
	
	public KecamatanServiceImplementation() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Collection<KecamatanEntity> getAllKecamatan() {
		// TODO Auto-generated method stub
		Iterable<KecamatanEntity> itr = kecamatanRepository.findAll();
		return (Collection<KecamatanEntity>)itr;
	}

	@Override
	public List<KecamatanEntity> findById(Integer kode) {
		// TODO Auto-generated method stub
		List<KecamatanEntity> list = kecamatanRepository.findByKabupaten_kode(kode);
		return list;
	}

}
