package io.github.julianjupiter.j2hrms.controller;

import io.github.julianjupiter.j2hrms.util.Attributes;
import io.github.julianjupiter.j2hrms.util.AuthUtil;
import io.github.julianjupiter.j2hrms.util.Templates;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/auth")
public class AuthenticationController extends BaseController {

	private static Logger logger = LoggerFactory.getLogger(AuthenticationController.class);
	private HttpServletRequest request;
	private AuthenticationManager authenticationManager;
	private UserDetailsService userDetailsService;
	@Value("${page.name.login}")
	private String pageName;
	@Value("${login.error.message}")
	private String loginErrorMessage;

	@Autowired
	public void getRequest(HttpServletRequest request) {
		this.request = request;
	}

	@Autowired()
	public void getAuthenticationManager(AuthenticationManager authenticationManager) {
		this.authenticationManager = authenticationManager;
	}

	@Autowired
	public void setUserDetailsService(UserDetailsService userDetailsService) {
		this.userDetailsService = userDetailsService;
	}

	@GetMapping({ "", "/", "/login" })
	public String login(Model model) {
		if (AuthUtil.isAuthenticated()) {
			logger.info("Redirects to home");
			return Attributes.REDIRECT_HOME;
		}

		boolean hasError = request.getParameterMap().containsKey(Attributes.ERROR);
		model.addAttribute(Attributes.HAS_ERROR, hasError);

		if (hasError) {
			logger.info("Login error");
			model.addAttribute(Attributes.LOGIN_ERROR_MESSAGE, loginErrorMessage);
		}

		model.addAttribute(Attributes.PAGE_NAME, pageName);

		return Templates.AUTH_LOGIN;
	}

}
