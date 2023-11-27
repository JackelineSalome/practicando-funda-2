package com.docseeker.Appointment.domain.persistence;

import com.docseeker.Appointment.domain.model.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {

    List<Appointment> getAppointmentsByPatientIdAndDoctorId(int patientId, int doctorId);

    List<Appointment> getAppointmentsByDoctorIdAndAndDate(Integer doctorId, String date);

    List<Appointment> getAppointmentsByPatientId(Integer patientId);

    List<Appointment> getAppointmentsByDoctorId(Integer doctorId);

}
