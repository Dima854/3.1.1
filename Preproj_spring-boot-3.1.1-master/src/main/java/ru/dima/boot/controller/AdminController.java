package ru.dima.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import ru.dima.boot.model.User;
import ru.dima.boot.service.RoleService;
import ru.dima.boot.service.UserService;

@Controller
public class AdminController {
    private final UserService userService;
    private final RoleService roleService;

    public AdminController (UserService userService,
                            RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping("/admin")
    public String getAdminPage(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "admin";
    }

    @GetMapping("/create")
    public String getCreatePage(ModelMap model) {
        model.addAttribute("allRoles", roleService.getAllRoles());
        model.addAttribute("newUser", new User());
        return "create";
    }

    @PostMapping("/create")
    public String createUser(@ModelAttribute User user) {
        User newUser = user;
        userService.createUser(newUser);
        return "redirect:/admin";
    }

    @PostMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") Long id, Model model) {
        User user = userService.getUserById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        model.addAttribute("editUser", user);
        model.addAttribute("allRoles", roleService.getAllRoles());
        return "update";
    }

    @PostMapping("/update")
    public String updateUser(@ModelAttribute User user) {
        userService.updateUser(user);
        return "redirect:/admin";
    }

    @PostMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") long id) {
        User user = userService.getUserById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        userService.deleteUser(user);
        return "redirect:/admin";
    }
}
