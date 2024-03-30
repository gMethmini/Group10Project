package com.csis3275.controller_group10;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.csis3275.model_group10.User;

import jakarta.servlet.http.HttpSession;

@Controller
public class PatientHomeController {

    @GetMapping("/patient/home")
    public String showPatientHomePage(Model model, HttpSession session) {
        // Check if user is authenticated as a patient
        User user = (User) session.getAttribute("user");
        if (user == null || !user.getRole().equals("PATIENT")) {
            return "redirect:/login"; // Redirect to login if not authenticated
        }
        
        // Add logic to fetch and display patient-specific data
        
        return "patient-home"; // Return the patient's home page view
    }
}

