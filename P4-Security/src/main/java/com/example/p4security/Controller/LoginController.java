package com.example.p4security.Controller;

import com.example.p4security.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/success")
    public String sucess() {
        return "success";
    }

    @GetMapping("/home")
    public String home(){
        return "home";
    }

    @PostMapping("/perform_login")
    public String performLogin(@RequestParam String username, @RequestParam String password) {
        return userService.verify(username, password);
    }
//    public String performLogin(@RequestBody Users users){
//        return userService.verify(users);
//    }
}