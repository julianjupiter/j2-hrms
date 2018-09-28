package io.github.julianjupiter.j2hrms.controller;

import io.github.julianjupiter.j2hrms.util.Attributes;
import io.github.julianjupiter.j2hrms.util.AuthUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

public abstract class BaseController {

	@Value("${application.name}")
	private String applicationName;

	@ModelAttribute
	public void addingCommonObjects(Model model) {
		model.addAttribute(Attributes.APPLICATION_NAME, applicationName);
		model.addAttribute(Attributes.USERNAME, AuthUtil.getUsername());
	}
}