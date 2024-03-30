package com.csis3275.controller_group10;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.csis3275.model_group10.Doctor;
import com.csis3275.model_group10.Patient;
import com.csis3275.model_group10.Receptionist;
import com.csis3275.model_group10.User;
import com.csis3275.repository.DoctorRepository;
import com.csis3275.repository.PatientRepository;
import com.csis3275.repository.ReceptionistRepository;
import com.csis3275.repository.UserRepository;

@Controller
public class RegistrationController {
	
	@Autowired
    private UserRepository userRepository;

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private PatientRepository patientRepository;
    
    @Autowired
    private ReceptionistRepository receptionistRepository;
    
	
	@GetMapping("/register")
    public String showRoleSelectionPage() {
        return "role-selection";
    }
	
	@GetMapping("/register/doctor")
    public String showDoctorRegistrationForm(Model model) {
        model.addAttribute("doctor", new Doctor());
        return "doctor-registration";
    }

    @GetMapping("/register/patient")
    public String showPatientRegistrationForm(Model model) {
        model.addAttribute("patient", new Patient());
        return "patient-registration";
    }
    
    @GetMapping("/register/receptionist")
    public String showReceptionistRegistrationForm(Model model) {
        model.addAttribute("receptionist", new Receptionist());
        return "receptionist-registration";
    }

    @PostMapping("/register/doctor")
    public String processDoctorRegistration(@ModelAttribute("doctor") Doctor doctor) {
        User user = new User();
        user.setName(doctor.getName());
        user.setEmail(doctor.getEmail());
        user.setPassword(doctor.getPassword());
        user.setRole("DOCTOR");
        userRepository.save(user);
        
        doctor.setRole("DOCTOR");
        doctorRepository.save(doctor);
        return "redirect:/login";
    }

    @PostMapping("/register/patient")
    public String processPatientRegistration(@ModelAttribute("patient") Patient patient) {
    	User user = new User();
        user.setName(patient.getName());
        user.setEmail(patient.getEmail());
        user.setPassword(patient.getPassword());
        user.setRole("PATIENT");
        userRepository.save(user);

        patient.setRole("PATIENT");
        patientRepository.save(patient);
        return "redirect:/login";
    }
    
    @PostMapping("/register/receptionist")
    public String processReceptionistRegistration(@ModelAttribute("receptionist") Receptionist receptionist) {
    	User user = new User();
        user.setName(receptionist.getName());
        user.setEmail(receptionist.getEmail());
        user.setPassword(receptionist.getPassword());
        user.setRole("RECEPTIONIST");
        userRepository.save(user);

        receptionist.setRole("RECEPTIONIST");
        receptionistRepository.save(receptionist);
        return "redirect:/login";
    }
}
