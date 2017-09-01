package com.dlc.repository;
import id.go.kemsos.simpkh.domain.kpm.KpmResertifikasiEntity;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TKPMRepository extends JpaRepository<KpmResertifikasiEntity, Integer>,JpaSpecificationExecutor<KpmResertifikasiEntity>{
	@Query(value="select a.nopeserta, a.namaart,a.kab_name,"
			+ "b.jkel,a.tahunkepesertaan,a.nmpendamping "
			+ "from (select c.nopeserta,c.namaart,d.kab_name,c.tahunkepesertaan,e.nmpendamping "
			+ "from t_kpm_resertifikasi c "
			+ "inner join mst_kabupaten d "
			+ "on c.kdkabu = d.kd_kab "
			+ "inner join m_pendamping e "
			+ "on c.kdpendamping = e.kdpendamping where hub_krt = '1' and c.kdprop = :prov "
			+ "and c.kdkabu = :kab and c.kdkeca = :kec and "
			+ "c.kdpendamping = :pdp and c.status =:stat) a "
			+ "inner join (select nopeserta,count(nopeserta) as jkel "
			+ "from t_kpm_resertifikasi group by nopeserta) b "
			+ "on (a.nopeserta = b.nopeserta)", nativeQuery = true)
	public List<Object[]> getCustomCount(@Param("prov") Integer prov,
			@Param("kab") Integer kab,
			@Param("kec") Integer kec,
			@Param("pdp") String pdp,
			@Param("stat") String stat);
	@Query(value="select a.nopeserta, a.namaart,a.kab_name,"
			+ "b.jkel,a.tahunkepesertaan,a.nmpendamping "
			+ "from (select c.nopeserta,c.namaart,d.kab_name,c.tahunkepesertaan,e.nmpendamping "
			+ "from t_kpm_resertifikasi c "
			+ "inner join mst_kabupaten d "
			+ "on c.kdkabu = d.kd_kab "
			+ "inner join m_pendamping e "
			+ "on c.kdpendamping = e.kdpendamping where hub_krt = '1' and c.kdprop = :prov "
			+ "and c.kdkabu = :kab and c.kdkeca = :kec and "
			+ "c.kdpendamping = :pdp ) a "
			+ "inner join (select nopeserta,count(nopeserta) as jkel "
			+ "from t_kpm_resertifikasi group by nopeserta) b "
			+ "on (a.nopeserta = b.nopeserta)", nativeQuery = true)
	public List<Object[]> getCustomCount(@Param("prov") Integer prov,
			@Param("kab") Integer kab,
			@Param("kec") Integer kec,
			@Param("pdp") String pdp);
}
