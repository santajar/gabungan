package com.dlc.repository;


<<<<<<< HEAD
import java.util.List;

=======
>>>>>>> 1cfa692fb81104205b06934495e2a542ccabc6b4
import org.springframework.data.repository.CrudRepository;

import id.go.kemsos.simpkh.domain.references.KabupatenEntity;


<<<<<<< HEAD
public interface KabupatenRepository extends CrudRepository<KabupatenEntity, Integer>{
//	@Query("SELECT * FROM mst_kabupaten AS rdt WHERE rdt.kode_prop = ?1")
	public List<KabupatenEntity> findByPropinsi_kode(Integer id);
}
=======
public interface KabupatenRepository extends CrudRepository<KabupatenEntity, Integer>{}
>>>>>>> 1cfa692fb81104205b06934495e2a542ccabc6b4
