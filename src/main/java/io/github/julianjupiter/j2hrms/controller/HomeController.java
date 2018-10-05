package io.github.julianjupiter.j2hrms.controller;

import io.github.julianjupiter.j2hrms.util.Attributes;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController extends BaseController {

	@Value("${page.name.home}")
	private String pageName;

	@GetMapping({"", "/", "/home"})
	public String index(Model model) {
		model.addAttribute(Attributes.PAGE_NAME, pageName);

		return "home/index";
	}
}
