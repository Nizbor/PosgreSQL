package sillysociety.org.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import sillysociety.org.config.MyUserDetails;
import sillysociety.org.service.UserService;

@Controller
@RequestMapping(path = "/")
public class TestSecurityController {
    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String rootPage() {
        return "login";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/logout")
    public String logout(Authentication authentication) {
        if (authentication != null) {
            authentication.setAuthenticated(false);
        }
        return "/login";
    }

    @GetMapping("/protected/profile")
    @PreAuthorize("hasAuthority('student')")
    public String profilePage(Model model, Authentication auth) {
        MyUserDetails userDetails = (MyUserDetails) auth.getPrincipal();
        String username = userDetails.getUsername();
        model.addAttribute("username", username);
        return "profile";
    }



}
