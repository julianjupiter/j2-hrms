package io.github.julianjupiter.j2hrms.service;

import io.github.julianjupiter.j2hrms.domain.Employee;
import io.github.julianjupiter.j2hrms.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Optional;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public Collection<Employee> findAll() {
		return this.employeeRepository.findAll();
	}

	@Override
	public Optional<Employee> findById(int id) {
		return this.employeeRepository.findById(id);
	}

}
