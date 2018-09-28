package io.github.julianjupiter.j2hrms.service;

import io.github.julianjupiter.j2hrms.domain.Employee;

import java.util.Collection;
import java.util.Optional;

public interface EmployeeService {
	
	Collection<Employee> findAll();

	Optional<Employee> findById(int id);
}
