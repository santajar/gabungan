package com.dlc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import id.go.kemsos.simpkh.domain.acl.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	
	User findByUsername(String username);

}