package com.dlc.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import id.go.kemsos.simpkh.domain.acl.User;

public interface UserService {
    void save(User user);
    void delete(User user);

    User findByUsername(String username);
    User findByID(Long id);
    Page<User> findAll(Pageable pageable);
}