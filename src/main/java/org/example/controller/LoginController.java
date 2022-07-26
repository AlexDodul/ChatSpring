package org.example.controller;

import org.example.entity.User;
import org.example.service.IUserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping
public class LoginController {

    private final IUserService userService;

    public LoginController(IUserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String loginView(Model model) {
        model.addAttribute("user", new User());

        return "login";
    }

    @PostMapping("/login")
    public String createUser(@ModelAttribute("user") User user, Model model, HttpServletResponse response) {
        if (userService.getByName(user.getName()) == null) {
            user = userService.createUser(user);
        }
        model.addAttribute("user", user);
        response.addCookie(new Cookie("userName", user.getName()));

        return "redirect:/chat";
    }
}
