package io.github.julianjupiter.j2hrms.controller;

import io.github.julianjupiter.j2hrms.domain.Employee;
import io.github.julianjupiter.j2hrms.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;
import java.util.Optional;

@Controller
@RequestMapping("/employees")
public class EmployeeController extends BaseController {
	private static Logger logger = LoggerFactory.getLogger(EmployeeController.class);
	@Autowired
	private HttpServletRequest request;
	@Autowired
	private EmployeeService employeeService;
	private static final String PAGE_NAME = "Employee";

	@GetMapping({"", "/"})
	public String findAll(Model model) {
		logger.info("{}", request.getRequestURL());

		Collection<Employee> employees = this.employeeService.findAll();

		model.addAttribute("pageName", PAGE_NAME);
		model.addAttribute("employees", employees);

		return "employee/findAll";
	}

	@GetMapping("/view/{id}")
	public String findById(Model model, @PathVariable("id") int id) {
		logger.info("{}", request.getRequestURL());

		Optional<Employee> employee = this.employeeService.findById(id);

		model.addAttribute("pageName", PAGE_NAME);
		model.addAttribute("employee", employee.get());

		return "employee/findById";
	}
}
