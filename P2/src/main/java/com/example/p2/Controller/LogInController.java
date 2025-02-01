package com.example.p2.Controller;

import com.example.p2.Entity.SignUpEntry;
import com.example.p2.Service.SignUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/p2")
public class LogInController {

    @Autowired
    private SignUpService signUpService;

    @GetMapping("/login")
    public String loginPage() {
        return "Login";
    }

    @PostMapping("/login")
    public String getDetails(@RequestParam  String email, @RequestParam String password, Model theModel){
        SignUpEntry user = signUpService.findByEmail(email);
        if (user != null && signUpService.validatePassword(password, user.getPassword())) {
            theModel.addAttribute("alertMessage", "Login successful");
            return "LoginSuccess";
        }else{
            theModel.addAttribute("alertMessage", "Login failed");
            return "Login";
        }
    }
}
