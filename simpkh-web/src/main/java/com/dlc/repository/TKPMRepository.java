package com.dlc.repository;
import id.go.kemsos.simpkh.domain.kpm.KpmResertifikasiEntity;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

public interface TKPMRepository extends JpaRepository<KpmResertifikasiEntity, Integer>,JpaSpecificationExecutor<KpmResertifikasiEntity>{
//	@Query(value ="select a.id.nomorPeserta, count(a.id.nomorPeserta) as jmlkel, a.alamat, a.tahunKepesertaan, b.nmpendamping "
//			+ "from KpmResertifikasiEntity a inner join KpmResertifikasiEntity.pendamping b on a.kdpendamping = b.kdpendamping "
//			+ "group by nomorPeserta, a.alamat, a.tahunKepesertaan, nmpendamping", nativeQuery = false)
	@Query(value="select nopeserta, count(nopeserta) as jkel from t_kpm_resertifikasi group by nopeserta", nativeQuery = true)
	public List<Object[]> getCustomCount();
}
