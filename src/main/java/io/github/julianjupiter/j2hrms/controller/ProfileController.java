package io.github.julianjupiter.j2hrms.controller;

import io.github.julianjupiter.j2hrms.domain.User;
import io.github.julianjupiter.j2hrms.service.UserService;
import io.github.julianjupiter.j2hrms.util.Attributes;
import io.github.julianjupiter.j2hrms.util.AuthUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;
import java.util.Optional;

@Controller
@RequestMapping("/profile")
public class ProfileController extends BaseController {

	private static Logger logger = LoggerFactory.getLogger(ProfileController.class);
	@Value("${page.name.profile}")
	private String pageName;
	@Autowired
	private HttpServletRequest request;
	@Autowired
	private UserService userService;

	@GetMapping({"", "/"})
	public String profile(Model model) {
		logger.info("{}", request.getRequestURL());

		Optional<User> user = this.userService.findByUsername(AuthUtil.getUsername());

		model.addAttribute(Attributes.PAGE_NAME, pageName);
		model.addAttribute(Attributes.USER, user.orElse(null));

		return "profile/profile";
	}
}
