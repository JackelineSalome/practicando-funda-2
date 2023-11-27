package com.docseeker.Appointment.mapping;

import com.docseeker.Appointment.domain.model.entity.Appointment;
import com.docseeker.Appointment.resource.AppointmentResource;
import com.docseeker.Appointment.resource.CreateAppointmentResource;
import com.docseeker.Appointment.resource.UpdateAppointmentResource;
import com.docseeker.Appointment.shared.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;

public class AppointmentMapper implements Serializable {
  @Autowired
  EnhancedModelMapper mapper;

  public Appointment toModel(CreateAppointmentResource resource) {
    return this.mapper.map(resource, Appointment.class);
  }
  public Appointment toModel(UpdateAppointmentResource resource) {
    return this.mapper.map(resource, Appointment.class);
  }
  public AppointmentResource toResource(Appointment appointment) {
    return this.mapper.map(appointment, AppointmentResource.class);
  }
}
