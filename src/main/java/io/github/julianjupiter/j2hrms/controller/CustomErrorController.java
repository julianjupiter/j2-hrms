package io.github.julianjupiter.j2hrms.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

@Controller
public class CustomErrorController implements ErrorController {

    @GetMapping("/error")
    public String handleError(HttpServletRequest request, Model model) {
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        if (status != null) {
            int statusCode = Integer.valueOf(status.toString());
            if (statusCode == HttpStatus.NOT_FOUND.value()) {
                model.addAttribute("message", "Page not found!");
                return "error/error";
            }

            if (statusCode == HttpStatus.FORBIDDEN.value()) {
                model.addAttribute("message", "Page denied access!");
                return "error/error";
            }
        }

        model.addAttribute("message", "Something went wrong!");

        return "error/error";
    }

    @Override
    public String getErrorPath() {
        return "/error";
    }
}
