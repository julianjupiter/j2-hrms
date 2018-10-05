package io.github.julianjupiter.j2hrms.service;

import io.github.julianjupiter.j2hrms.domain.Role;
import io.github.julianjupiter.j2hrms.domain.User;
import io.github.julianjupiter.j2hrms.repository.RoleRepository;
import io.github.julianjupiter.j2hrms.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service("customUserDetailsService")
@Transactional
public class CustomUserDetailsServiceImpl implements UserDetailsService, UserService {
	private static Logger logger = LoggerFactory.getLogger(CustomUserDetailsServiceImpl.class);
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) {
		User user = this.findByUsername(username).orElse(null);

		if (null == user) {
			throw new UsernameNotFoundException("User " + username + " does not exist.");
		}

		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), user.isEnabled(), true, true, true, this.grantedAuthorities(user.getRoles()));
	}

    @Override
    public Collection<User> findAll() {
        return this.userRepository.findAll();
    }

    @Override
    public Optional<User> findById(int id) {
        return this.userRepository.findById(id);
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return this.userRepository.findByUsername(username);
    }

    private Set<GrantedAuthority> grantedAuthorities(Set<Role> roles) {
		return roles.stream()
			.map(role -> new SimpleGrantedAuthority(role.getCode()))
			.collect(Collectors.toSet());
	}

}
