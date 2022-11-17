package web.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import web.model.User;
import web.service.UserService;
import web.service.UserServiceImpl;

import java.util.List;

@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }


    @GetMapping(value = "/")
    public String showAllUsers(Model model) {
        List<User> allUsers = userService.getAllUsers();
        model.addAttribute("users", allUsers);
        return "users";
    }

    @GetMapping(value = "/add")
    public String createUser(Model model) {
        User user = new User();
        model.addAttribute("user", user);

        return "users_info";
    }

    @PostMapping("/saveUser")
    public String saveEmployee(User user) {
        userService.add(user);
        return "redirect:/";
    }


    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id) {

        userService.delete(id);
        return "redirect:/";
    }

    @GetMapping("/updateUser/{id}")
    public String updateUserForm(@PathVariable("id") Long id, Model model) {
        User userForm = userService.getUser(id);
        model.addAttribute("userForm", userForm);
        System.out.println("da!!!");
        return "users_update";


    }

    @PostMapping("/update")
    public String updateUser(User user) {
        System.out.println("nooo!!!");
        userService.update(user);
        System.out.println("yees!!!");
        return "redirect:/";
    }

}
