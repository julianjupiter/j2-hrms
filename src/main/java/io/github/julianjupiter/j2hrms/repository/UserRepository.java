package io.github.julianjupiter.j2hrms.repository;

import io.github.julianjupiter.j2hrms.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
	
	User findByUsername(String username);
	
}
