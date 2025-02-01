package com.example.p2.Controller;

import com.example.p2.Entity.SignUpEntry;
import com.example.p2.Service.EmailService;
import com.example.p2.Service.SignUpService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Random;

@Controller
@RequestMapping("/p2")
public class ForgotPasswordController {

    @Autowired
    private EmailService emailService;

    @Autowired
    private SignUpService signUpService;

    @GetMapping("/forgotpassword")
    public String forgotPassword() {
        return "forgotpassword";
    }

    @PostMapping("/send-otp")
    public String sendOtp(@RequestParam("email") String email, Model m, HttpSession session) {
        System.out.println("Email: " + email);

        // Generating OTP
        Random random = new Random();
        int otp = random.nextInt(999999);
        System.out.println("OTP: " + otp);

        String subject = "Verification OTP";
        String message = "<h1>The OTP for verification is: " + otp + "</h1>";
        String to = email;

        // Sending email
        boolean isEmailSent = emailService.sendEmail(subject, message, to);

        if (isEmailSent) {
            session.setAttribute("otp", otp);  // Store OTP in session
            m.addAttribute("alertMessage", "OTP sent successfully");
            return "verify-otp";
        } else {
            m.addAttribute("error", "OTP Error. Please try again.");
            return "forgotpassword";
        }
    }

    @PostMapping("/verify-otp")
    public String verifyOtp(@RequestParam("otp") String enteredOtp, Model m, HttpSession session) {
        // Retrieve stored OTP from session
        Integer storedOtp = (Integer) session.getAttribute("otp");

        if (storedOtp == null) {
            m.addAttribute("alertMessage", "OTP expired or not generated.");
            return "verify-otp";
        }

        if (enteredOtp.equals(String.valueOf(storedOtp))) {
            m.addAttribute("alertMessage", "OTP Verified");
            return "Set-Password";
        } else {
            m.addAttribute("alertMessage", "OTP Error");
            return "verify-otp";
        }
    }

    @PostMapping("/reset-passwFord")
    public String resetPassword(@RequestParam("email") String email, @RequestParam("newPassword") String newPassword, Model m, HttpSession session) {
        SignUpEntry user = signUpService.findByEmail(email);

        if (user != null) {
            System.out.println("New Password: " + newPassword);
            user.setPassword(newPassword);

            signUpService.saveDetails(user);
            session.removeAttribute("otp");

            m.addAttribute("alertMessage", "Password successfully updated");
            return "Login";
        } else {
            m.addAttribute("alertMessage", "User not found.");
            return "forgotpassword";
        }
    }

}