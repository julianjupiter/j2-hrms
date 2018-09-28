package io.github.julianjupiter.j2hrms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping({"", "/", "/home"})
	public String index() {
		return "home/index";
	}
}
