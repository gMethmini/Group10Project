package com.csis3275.controller_group10;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.csis3275.model_group10.Patient;
import com.csis3275.model_group10.User;
import com.csis3275.repository.PatientRepository;

import jakarta.servlet.http.HttpSession;

@Controller
public class DoctorHomeController {

	@Autowired
    private PatientRepository patientRepository;

    @GetMapping("/doctor/home")
    public String showDoctorHomePage(Model model, HttpSession session) {
    	
    	// Check if user is authenticated as a doctor
        User user = (User) session.getAttribute("user");
        if (user == null || !user.getRole().equals("DOCTOR")) {
            return "redirect:/login"; // Redirect to login if not authenticated
        }
        
        // Fetch the logged-in doctor's ID
        //Long doctorId = user.getId();
        
        // Fetch all patient records
        //List<Patient> patients = patientRepository.findByDoctorId(doctorId);
        
        // Add patient data to the model
        //model.addAttribute("patients", patients);
        //Add doctor's name to the model
        model.addAttribute("doctorName", user.getName());
        
        return "doctor-home";
    }
}
