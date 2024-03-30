package com.csis3275.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.csis3275.model_group10.Appointment;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

}
