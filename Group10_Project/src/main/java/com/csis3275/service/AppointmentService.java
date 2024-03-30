package com.csis3275.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csis3275.model_group10.Appointment;
import com.csis3275.repository.AppointmentRepository;
@Service
public class AppointmentService {
	
	@Autowired
    private AppointmentRepository appointmentRepository;
	
	 public Appointment createAppointment(Appointment appointment) {
	        return appointmentRepository.save(appointment);
	    }

	    public List<Appointment> getAllAppointments() {
	        return appointmentRepository.findAll();
	    }

	    public Appointment getAppointmentById(Long id) {
	        return appointmentRepository.findById(id).orElse(null);
	    }
	    
	    public Appointment saveAppointment(Appointment appointment) {
	        return appointmentRepository.save(appointment);
	    }

	    public void deleteAppointment(Long id) {
	        appointmentRepository.deleteById(id);
	    }
}
