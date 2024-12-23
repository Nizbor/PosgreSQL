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
    @PreAuthorize("hasAuthority('admin')")
    public String profilePage(Model model, Authentication auth) {
        MyUserDetails userDetails = (MyUserDetails) auth.getPrincipal();
        String username = userDetails.getUsername();

        User user = userService.getUserById(userDetails.getId());


        model.addAttribute("username", user.getFirstName());
        return "profile";
    }

    @Autowired
    private FileService fileService;

    @GetMapping("/protected/file")
    @PreAuthorize("hasAuthority('admin')")
    public String filePage(Model model, Authentication auth) {
        MyUserDetails userDetails = (MyUserDetails) auth.getPrincipal();

        model.addAttribute("files", fileService.getAllAvailableFiles(userDetails.getId()));
        model.addAttribute("user", userDetails.getUser());
        return "listFiles";
    }

    @GetMapping("/protected/general")
    @PreAuthorize("hasAuthority('admin')")
    public String generalPage(Model model, Authentication auth) {
        MyUserDetails userDetails = (MyUserDetails) auth.getPrincipal();
        model.addAttribute("user", userDetails.getUser());
        return "general";
    }

    @GetMapping("/protected/message")
    @PreAuthorize("hasAuthority('admin')")
    public String messagePage(Model model, Authentication auth) {
        MyUserDetails userDetails = (MyUserDetails) auth.getPrincipal();
        model.addAttribute("user", userDetails.getUser());
        return "message";
    }

}
