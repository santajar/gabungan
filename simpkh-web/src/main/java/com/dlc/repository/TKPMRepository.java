package com.dlc.repository;
import id.go.kemsos.simpkh.domain.kpm.KpmResertifikasiEntity;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

public interface TKPMRepository extends JpaRepository<KpmResertifikasiEntity, Integer>,JpaSpecificationExecutor<KpmResertifikasiEntity>{
	@Query(value ="select a.nomorPeserta, count(a.nomorPeserta) as jmlkel, a.alamat, a.tahunKepesertaan, b.nmpendamping "
			+ "from t_kpm_resertifikasi a inner join m_pendamping b on a.kdpendamping = b.kdpendamping "
			+ "group by nomorPeserta, a.alamat, a.tahunKepesertaan, pendamping", nativeQuery = true)
	public List<KpmResertifikasiEntity> findAll();
}
