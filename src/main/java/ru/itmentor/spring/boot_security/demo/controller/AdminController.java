package ru.itmentor.spring.boot_security.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.itmentor.spring.boot_security.demo.dto.UserRequestDto;
import ru.itmentor.spring.boot_security.demo.service.RoleService;
import ru.itmentor.spring.boot_security.demo.service.UserService;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final UserService userService;
    private final RoleService roleService;

    @Autowired
    public AdminController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping("/new")
    public String newUserForm(Model model) {
        /*Вы Игнату поправили момент, что он отправлял отдельно роли, но не знаю где.
         *Я тут выгружаю из бд все роли.
         *Можно сделать отдельное дто для этого и там форму придется немного менять*/
        model.addAttribute("user", new UserRequestDto());
        model.addAttribute("allRoles", roleService.getAllRoles());
        return "admin.newUser";
    }

    @PostMapping("/new")
    public String addUser(@ModelAttribute UserRequestDto userRequestDto) {
        userService.addUser(userRequestDto);
        return "redirect:/admin";
    }

    @GetMapping
    public String getAllUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "admin.users";
    }

    @GetMapping("/user/{id}")
    public String showUserInfo(@PathVariable Long id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "admin.infoUser";
    }

    @GetMapping("/edit/{id}")
    public String editUserForm(@PathVariable Long id, Model model) {
        /*Тут такая же ситуация*/
        model.addAttribute("user", userService.getUserById(id));
        model.addAttribute("allRoles", roleService.getAllRoles());
        return "admin.updateUser";
    }

    @PostMapping("/edit")
    public String updateUser(@ModelAttribute UserRequestDto userRequestDto) {
        userService.updateUser(userRequestDto);
        return "redirect:/admin";
    }

    @PostMapping("/delete/{id}")
    public String deleteUser(@PathVariable Long id) {
        userService.removeUser(id);
        return "redirect:/admin";
    }
}