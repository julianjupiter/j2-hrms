package io.github.julianjupiter.j2hrms.service;

import io.github.julianjupiter.j2hrms.domain.User;

import java.util.Collection;
import java.util.Optional;

public interface UserService {

    Collection<User> findAll();

    Optional<User> findById(int id);

    Optional<User> findByUsername(String username);

}
