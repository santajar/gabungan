package com.dlc.service;


import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.Query;

import id.go.kemsos.simpkh.domain.kpm.KpmResertifikasiEntity;



public interface TKPMServiceInterface {

//	@Query(value ="select a.nomorPeserta, count(a.nomorPeserta) as jmlkel, a.alamat, a.tahunKepesertaan, b.nmpendamping "
//			+ "from KpmResertifikasiEntity a inner join PendampingEntity b on a.kdpendamping = b.kdpendamping "
//			+ "group by nomorPeserta, a.alamat, a.tahunKepesertaan, pendamping", nativeQuery = false)
	public List<Object[]> findAll();
//	public Collection<KpmResertifikasiEntity> getAll();
}
