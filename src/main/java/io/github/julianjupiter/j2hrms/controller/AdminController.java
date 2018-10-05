package io.github.julianjupiter.j2hrms.controller;

import io.github.julianjupiter.j2hrms.util.Attributes;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController extends BaseController {

    @Value("${page.name.dashboard}")
    private String pageName;

    @GetMapping({ "", "/" })
    public String index(Model model) {
        model.addAttribute(Attributes.PAGE_NAME, pageName);

        return "admin/index";
    }

    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        model.addAttribute(Attributes.PAGE_NAME, pageName);

        return "admin/dashboard";
    }
}
