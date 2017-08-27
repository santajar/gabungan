package com.dlc.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import id.go.kemsos.simpkh.domain.acl.User;

public interface UserService {
    void save(User user);
    void delete(User user);

    User findByUsername(String username);
    User findByID(Long id);
<<<<<<< HEAD
    Page<User> findAll(Pageable pageable);
=======
>>>>>>> 1cfa692fb81104205b06934495e2a542ccabc6b4
}