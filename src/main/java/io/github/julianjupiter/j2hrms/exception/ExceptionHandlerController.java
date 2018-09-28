package io.github.julianjupiter.j2hrms.exception;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ExceptionHandlerController {

	@ExceptionHandler(AccessDeniedException.class)
	public String handleAccessDeniedException(AccessDeniedException exception, HttpServletRequest request, Model model) {
		model.addAttribute("pageName", "Page Access Denied");
		
		return "error/pageAccessDenied";
	}

	@ExceptionHandler(NoHandlerFoundException.class)
	public String handleNoHandlerFoundException(NoHandlerFoundException exception, HttpServletRequest request, Model model) {
		model.addAttribute("pageName", "Page Not Found");
		
		return "error/pageNotFound";
	}
	
}
