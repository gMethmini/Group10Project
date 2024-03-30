package com.csis3275.controller_group10;




import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.csis3275.model_group10.Appointment;
import com.csis3275.model_group10.Doctor;
import com.csis3275.model_group10.Patient;
import com.csis3275.model_group10.User;
import com.csis3275.service.AppointmentService;
import com.csis3275.service.DoctorService;
import com.csis3275.service.PatientService;

import jakarta.servlet.http.HttpSession;

@Controller
public class ReceptionistHomeController {
	
	@Autowired
    private AppointmentService appointmentService;

    @Autowired
    private DoctorService doctorService;

    @Autowired
    private PatientService patientService;
    
    @GetMapping("/receptionist/home")
    public String showReceptionistHomePage(Model model, HttpSession session) {
        // Check if user is authenticated as a receptionist
        User user = (User) session.getAttribute("user");
        if (user == null || !user.getRole().equals("RECEPTIONIST")) {
            return "redirect:/login"; // Redirect to login if not authenticated
        }
        
        model.addAttribute("receptionistName", user.getName());
        return "receptionist-home"; // Return the receptionist's home page view
    }
    
    @GetMapping("/receptionist/appointments")
    public String showAppointmentForm(Model model) {
        List<Doctor> doctors = doctorService.getAllDoctors();
        List<Patient> patients = patientService.getAllPatients();
        model.addAttribute("doctors", doctors);
        model.addAttribute("patients", patients);
        return "appointment-form";
    }
    
    @PostMapping("/receptionist/appointments/add")
    public String addAppointment(Appointment appointment) {
        // Handle adding appointment logic here
        appointmentService.saveAppointment(appointment);
        return "redirect:/receptionist/home";
    }
}
