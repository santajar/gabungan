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
	@Query(value="select a.nopeserta, a.namaart,a.kab_name,"
			+ "b.jkel,a.tahunkepesertaan,a.nmpendamping "
			+ "from (select c.nopeserta,c.namaart,d.kab_name,c.tahunkepesertaan,e.nmpendamping "
			+ "from t_kpm_resertifikasi c "
			+ "inner join mst_kabupaten d "
			+ "on c.kdkabu = d.kd_kab "
			+ "inner join m_pendamping e "
			+ "on c.kdpendamping = e.kdpendamping where hub_krt = '1') a "
			+ "inner join (select nopeserta,count(nopeserta) as jkel "
			+ "from t_kpm_resertifikasi group by nopeserta) b "
			+ "on (a.nopeserta = b.nopeserta)", nativeQuery = true)
	public List<Object[]> getCustomCount();
}
