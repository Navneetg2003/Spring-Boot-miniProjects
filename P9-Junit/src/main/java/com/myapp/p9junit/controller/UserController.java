package com.myapp.p9junit.controller;

import com.myapp.p9junit.model.User;
import com.myapp.p9junit.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @PostMapping
    public void addUser(@RequestBody User user) {
        userService.addUser(user);
    }
}
