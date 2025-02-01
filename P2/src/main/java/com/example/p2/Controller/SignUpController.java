package com.example.p2.Controller;

import com.example.p2.Entity.SignUpEntry;
import com.example.p2.Service.SignUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/p2")
public class SignUpController {

    @Autowired
    private SignUpService signUpService;

    @GetMapping("/signin")
    public String signup() {
        return "SignUp";
    }

    @PostMapping("/signup")
    public String submit(@ModelAttribute SignUpEntry signUpEntry, Model themodel) {
            signUpService.saveDetails(signUpEntry);
            return "Success";
    }

    @GetMapping("/check-email")
    @ResponseBody
    public boolean checkEmailExistence(@RequestParam("email") String email) {
        return signUpService.findByEmail(email) != null;
    }


}

//        SignUpEntry user = signUpService.findByEmail(signUpEntry.getEmail());
//        if (user != null) {
//            themodel.addAttribute("alertMessage", "This email already exists");
//            return "SignUp";
//        }else{
//        }






//        if (errorMessage != null) {
//            themodel.addAttribute("alertMessage", "This email already exists");
//            return "SignUp";
//        }else{
//        }
