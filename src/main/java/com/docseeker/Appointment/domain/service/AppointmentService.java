package com.docseeker.Appointment.domain.service;

import com.docseeker.Appointment.domain.model.entity.Appointment;

import java.util.List;
import java.util.Optional;

public interface AppointmentService {
  List<Appointment> fetchAll();
  Optional<Appointment> fetchById(Integer id);
  Appointment save(Appointment appointment);
  Appointment update(Appointment appointment);
  boolean deleteById(Integer id);
  List<Appointment> fetchByPatientAndDoctorId(Integer patientId, Integer doctorId);

  List<Appointment> fetchByDoctorIdAndDate(Integer doctorId, String date);

  List<Appointment> fetchByPatientId(Integer patientId);

  List<Appointment> fetchByDoctorId(Integer doctorId);
}
