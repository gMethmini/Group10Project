package com.csis3275.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.csis3275.model_group10.Patient;

public interface PatientRepository extends JpaRepository<Patient, Long> {
}
