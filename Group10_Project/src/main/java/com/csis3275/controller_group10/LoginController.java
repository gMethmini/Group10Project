package com.csis3275.controller_group10;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.csis3275.model_group10.User;
import com.csis3275.repository.UserRepository;

import jakarta.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/login")
    public String showLoginPage() {
        return "Login"; 
    }
    
    @PostMapping("/login")
    public String login(@RequestParam String email, @RequestParam String password, HttpSession session) {
        User user = userRepository.findByEmailAndPassword(email, password); // Perform authentication
        if (user != null) {
        	session.setAttribute("user", user); // Store user in session for authentication
        	// Redirect to respective home page based on user's role
            switch (user.getRole()) {
                case "DOCTOR":
                    return "redirect:/doctor/home";
                case "PATIENT":
                    return "redirect:/patient/home";
                case "RECEPTIONIST":
                    return "redirect:/receptionist/home";
                default:
                    return "redirect:/";
            }
        }else {
        	return "redirect:/login?error=true";
        }
    }
}

