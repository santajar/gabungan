package com.dlc.service;

import id.go.kemsos.simpkh.domain.acl.User;

public interface UserService {
    void save(User user);
    void delete(User user);

    User findByUsername(String username);
    User findByID(Long id);
}