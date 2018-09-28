package io.github.julianjupiter.j2hrms.service;

import io.github.julianjupiter.j2hrms.domain.Role;
import io.github.julianjupiter.j2hrms.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Optional;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {
	
	@Autowired
	private RoleRepository roleRepository;

	@Override
	public Collection<Role> findAll() {
		return this.roleRepository.findAll();
	}

	@Override
	public Optional<Role> findById(int id) {
		return this.roleRepository.findById(id);
	}

}
