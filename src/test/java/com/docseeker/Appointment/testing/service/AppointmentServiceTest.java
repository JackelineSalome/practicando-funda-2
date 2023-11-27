package com.docseeker.Appointment.testing.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import com.docseeker.Appointment.domain.model.entity.Appointment;
import com.docseeker.Appointment.domain.persistence.AppointmentRepository;
import com.docseeker.Appointment.service.AppointmentServiceImpl;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

public class AppointmentServiceTest {
  @InjectMocks
  private AppointmentServiceImpl appointmentService;

  @Mock
  private AppointmentRepository appointmentRepository;

  @BeforeEach
  public void setUp() {
    MockitoAnnotations.openMocks(this);
  }

  @Test
  public void testFetchAll() {
    List<Appointment> appointments = new ArrayList<>();
    appointments.add(new Appointment(1, "1-1-23","4:00","6:00",1,1));
    appointments.add(new Appointment(2, "2-2-22","5:00","7:00",3,3));

    when(appointmentRepository.findAll()).thenReturn(appointments);

    List<Appointment> fetchedAppointments = appointmentService.fetchAll();
    assertEquals(appointments.size(), fetchedAppointments.size());
    assertEquals(appointments, fetchedAppointments);
  }

  @Test
  public void testFetchById() {
    Appointment appointment = new Appointment(1, "1-1-23","4:00","6:00",1,1);

    when(appointmentRepository.findById(1)).thenReturn(Optional.of(appointment));

    Optional<Appointment> fetchedAppointment = appointmentService.fetchById(1);
    assertTrue(fetchedAppointment.isPresent());
    assertEquals(appointment, fetchedAppointment.get());
  }

  @Test
  public void testSave() {
    Appointment appointment = new Appointment(1, "1-1-23","4:00","6:00",1,1);

    when(appointmentRepository.save(appointment)).thenReturn(appointment);

    Appointment savedAppointment = appointmentService.save(appointment);
    assertEquals(appointment, savedAppointment);
  }

  @Test
  public void testUpdate() {
    Appointment appointment = new Appointment(1, "1-1-23","4:00","6:00",1,1);

    when(appointmentRepository.save(appointment)).thenReturn(appointment);

    Appointment updatedAppointment = appointmentService.update(appointment);
    assertEquals(appointment, updatedAppointment);
  }

  @Test
  public void testDeleteById() {
    when(appointmentRepository.existsById(1)).thenReturn(true);

    boolean result = appointmentService.deleteById(1);
    assertTrue(result);
  }

  @Test
  public void testDeleteById_AppointmentNotFound() {
    when(appointmentRepository.existsById(2)).thenReturn(false);

    boolean result = appointmentService.deleteById(2);
    assertFalse(result);
  }
}
