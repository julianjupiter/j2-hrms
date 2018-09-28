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

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service("customUserDetailsService")
@Transactional
public class CustomUserDetailsServiceImpl implements UserDetailsService {
	private static Logger logger = LoggerFactory.getLogger(CustomUserDetailsServiceImpl.class);
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;

	@Override
	public UserDetails loadUserByUsername(String username) {
		logger.info("USERNAME:" + username);
		User user = this.userRepository.findByUsername(username);
		logger.info("USER:" + user.getEmployeeId() + "|" + user.getUsername() + "|" + user.getPassword() + "|" + user.getRoleId());

		if (null == user) {
			throw new UsernameNotFoundException("User " + username + " does not exist.");
		}

		return new org.springframework.security.core.userdetails.User(
				user.getUsername(),
				user.getPassword(),
				user.isEnabled(),
				true,
				true,
				true, this.grantedAuthorities(user));
	}

	private Set<GrantedAuthority> grantedAuthorities(User user) {
		Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
		Optional<Role> roleOptional = this.roleRepository.findById(user.getId());
		SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(roleOptional.get().getCode());
		grantedAuthorities.add(simpleGrantedAuthority);

		return grantedAuthorities;
	}

}
