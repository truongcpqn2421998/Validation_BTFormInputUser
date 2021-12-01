package com.codegym.service;

import com.codegym.model.User;

import java.util.List;
import java.util.Optional;

public interface IUserService {
    Iterable<User> findAll();

    Optional<User> findById(Long id);

    void save(User user);

    void remove(Long id);
}
