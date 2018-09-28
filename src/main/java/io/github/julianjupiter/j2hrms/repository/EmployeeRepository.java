package io.github.julianjupiter.j2hrms.repository;

import io.github.julianjupiter.j2hrms.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
