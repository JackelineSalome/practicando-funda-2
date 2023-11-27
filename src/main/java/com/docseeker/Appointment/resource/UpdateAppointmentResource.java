package com.docseeker.Appointment.resource;

import lombok.*;

@Getter
@Setter
@With
@AllArgsConstructor
@NoArgsConstructor
public class UpdateAppointmentResource {
  private Integer id;

  private String date;

  private String startTime;

  private String endTime;

  private Integer doctorId;

  private Integer patientId;

  public Integer getId() {
    return id;
  }
}
