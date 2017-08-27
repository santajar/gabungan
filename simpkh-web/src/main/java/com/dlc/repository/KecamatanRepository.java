package com.dlc.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import id.go.kemsos.simpkh.domain.references.KecamatanEntity;

public interface KecamatanRepository extends CrudRepository<KecamatanEntity, Integer>{
	public List<KecamatanEntity> findByKabupaten_kode(Integer id);
}
