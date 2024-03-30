package com.csis3275.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csis3275.model_group10.Patient;
import com.csis3275.repository.PatientRepository;

@Service
public class PatientService {
	@Autowired
    private PatientRepository patientRepository;

	public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    public Patient getPatientById(Long id) {
        return patientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Patient not found with id: " + id));
    }

    public Patient savePatient(Patient patient) {
        return patientRepository.save(patient);
    }
	
	// Methods for patient-related operations: savePatient, findPatientByName, etc.
}
