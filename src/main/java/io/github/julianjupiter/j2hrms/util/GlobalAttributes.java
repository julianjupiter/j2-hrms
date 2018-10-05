package io.github.julianjupiter.j2hrms.util;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice
public class GlobalAttributes {
    @ModelAttribute
    public void attributes(Model model) {
        model.addAttribute("isAuthenticated", AuthUtil.isAuthenticated());
    }
}
