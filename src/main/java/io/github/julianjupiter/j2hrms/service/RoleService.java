package io.github.julianjupiter.j2hrms.service;

import io.github.julianjupiter.j2hrms.domain.Role;

import java.util.Collection;
import java.util.Optional;

public interface RoleService {
	
	Collection<Role> findAll();

	Optional<Role> findById(int id);
}
