package com.dlc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import id.go.kemsos.simpkh.domain.acl.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	
	User findByUsername(String username);
	
//	@Query("SELECT  * FROM m_user as mu "
//			+" LEFT JOIN mst_propinsi as mp ON mp.kd_prop = mu.kdprop::INTEGER "
//			+" LEFT JOIN mst_kabupaten as mk ON mk.kd_kab = mu.kdkabu::INTEGER"
//			+" LEFT JOIN mst_kecamatan as mke ON mke.kd_kec = mu.kdkeca::INTEGER")
//	Iterable<User> findTabelAll();
	
	User findByid(Long id);

}
