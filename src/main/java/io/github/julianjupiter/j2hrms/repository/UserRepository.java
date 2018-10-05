package io.github.julianjupiter.j2hrms.repository;

import io.github.julianjupiter.j2hrms.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
	
	Optional<User> findByUsername(String username);
	
}
