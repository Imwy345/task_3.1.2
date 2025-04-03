package ru.itmentor.spring.boot_security.demo.controller;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.itmentor.spring.boot_security.demo.model.User;
import ru.itmentor.spring.boot_security.demo.service.UserService;

@Controller
public class UserController {

//    private final UserService userService;
//
//    public UserController(UserService userService) {
//        this.userService = userService;
//    }
//
//    @GetMapping("/")
//    public String allUsers(Model model) {
//        model.addAttribute("users", userService.getAllUsers());
//        return "users";
//    }
//
//    @GetMapping("/{id}")
//    public String getUser(@PathVariable("id") int id, Model model) {
//        model.addAttribute("user", userService.getUserById(id));
//        return "user";
//    }
//
//    @GetMapping("/new")
//    public String addUser(User user) {
//        return "newUser";
//    }
//
//    @PostMapping("/new")
//    public String add(@ModelAttribute("user") @Valid User user, BindingResult bindingResult) {
//        if (bindingResult.hasErrors()) {
//            return "newUser";
//        } else {
//            userService.addUser(user);
//            return "redirect:/";
//        }
//    }
//
//    @GetMapping("/{id}/update")
//    public String updateUser(@PathVariable("id") int id, Model model) {
//        model.addAttribute("user", userService.getUserById(id));
//        return "updateUser";
//    }
//
//    @PostMapping("/update/{id}")
//    public String update(@PathVariable("id") long id, @Valid User user, BindingResult bindingResult) {
//        if (bindingResult.hasErrors()) {
//            return "updateUser";
//        } else {
//            user.setId(id);
//            userService.updateUser(user);
//            return "redirect:/";
//        }
//    }
//
//    @PostMapping("/delete/{id}")
//    public String delete(@PathVariable("id") int id) {
//        userService.removeUser(id);
//        return "redirect:/";
//    }
//
//    @GetMapping("/favicon.ico")
//    public void favicon() {
//        // favicon.ico
//    }
}