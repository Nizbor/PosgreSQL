package sillysociety.org.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import sillysociety.org.config.MyUserDetails;
import sillysociety.org.models.User;
import sillysociety.org.service.FileService;
import sillysociety.org.service.UserService;

@Controller
@RequestMapping(path = "/")
public class TestSecurityController {
    @Autowired
    private UserService userService;
    @Autowired
    private FileService fileService;

    @GetMapping("/")
    public String rootPage(Model model, Authentication auth) {
        if (auth != null) {
            MyUserDetails userDetails = (MyUserDetails) auth.getPrincipal();
            model.addAttribute("user", userDetails.getUser());
            return "general";
        } else {
            return "redirect:/login";
        }
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

    @GetMapping("/profile")
    public String profilePage(Model model, Authentication auth) {
        MyUserDetails userDetails = (MyUserDetails) auth.getPrincipal();
        User user = userService.getUserById(userDetails.getId());

        model.addAttribute("username", user.getFirstName());
        return "profile";
    }

    @GetMapping(path = "/general")
    public String rootPage() {
        return "redirect:/";
    }

    @GetMapping("/file")
    public String filePage(Model model, Authentication auth) {
        MyUserDetails userDetails = (MyUserDetails) auth.getPrincipal();

        model.addAttribute("user", userDetails.getUser());
        model.addAttribute("files", fileService.getAllAvailableFiles(userDetails.getId()));
        return "listFiles";
    }


}
