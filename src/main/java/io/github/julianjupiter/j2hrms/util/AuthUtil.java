package io.github.julianjupiter.j2hrms.util;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

public class AuthUtil {
	
	private AuthUtil() {}
	
	public static Authentication getAuthentication() {
		return SecurityContextHolder.getContext().getAuthentication();
	}
	
	public static String getUsername() {
		Authentication authentication = getAuthentication();
		Object principal = authentication.getPrincipal();
		
		if (!(authentication instanceof AnonymousAuthenticationToken)) {
			User user = (User) principal;
			return user.getUsername();
		}
		
		return principal.toString();
	}

	public static boolean isLoggedIn() {
		return !(getAuthentication() instanceof AnonymousAuthenticationToken);
	}
	
}
