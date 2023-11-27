package com.docseeker.Appointment.service;

import com.docseeker.Appointment.domain.model.entity.Appointment;
import com.docseeker.Appointment.domain.persistence.AppointmentRepository;
import com.docseeker.Appointment.domain.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppointmentServiceImpl implements AppointmentService {
  @Autowired
  private AppointmentRepository appointmentRepository;
  @Override
  public List<Appointment> fetchAll() {
    return appointmentRepository.findAll();
  }

  @Override
  public Optional<Appointment> fetchById(Integer id) {
    return appointmentRepository.findById(id);
  }

  @Override
  public Appointment save(Appointment appointment) {
    return appointmentRepository.save(appointment);
  }

  @Override
  public Appointment update(Appointment appointment) {
    return appointmentRepository.save(appointment);
  }

  @Override
  public boolean deleteById(Integer id) {
    if (appointmentRepository.existsById(id)) {
      appointmentRepository.deleteById(id);
      return true;
    }
    return false;
  }

  @Override
  public List<Appointment> fetchByPatientAndDoctorId(Integer patientId, Integer doctorId) {
    return appointmentRepository.getAppointmentsByPatientIdAndDoctorId(patientId, doctorId);
  }

  @Override
  public List<Appointment> fetchByDoctorIdAndDate(Integer doctorId, String date) {
    return appointmentRepository.getAppointmentsByDoctorIdAndAndDate(doctorId, date);
  }

  @Override
  public List<Appointment> fetchByPatientId(Integer patientId) {
    return appointmentRepository.getAppointmentsByPatientId(patientId);
  }

  @Override
  public List<Appointment> fetchByDoctorId(Integer doctorId) {
    return appointmentRepository.getAppointmentsByDoctorId(doctorId);
  }
}
