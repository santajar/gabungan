package com.dlc.repository;


import java.util.List;

import org.springframework.data.repository.CrudRepository;

import id.go.kemsos.simpkh.domain.references.KabupatenEntity;


public interface KabupatenRepository extends CrudRepository<KabupatenEntity, Integer>{
//	@Query("SELECT * FROM mst_kabupaten AS rdt WHERE rdt.kode_prop = ?1")
	public List<KabupatenEntity> findByPropinsi_kode(Integer id);
}
