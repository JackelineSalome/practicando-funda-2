package com.docseeker.Appointment.resource;

import lombok.*;

@Getter
@Setter
@With
@AllArgsConstructor
@NoArgsConstructor
public class AppointmentResource {

  private Integer id;

  private String date;

  private String startTime;

  private String endTime;

  private Integer doctorId;

  private Integer patientId;
}
