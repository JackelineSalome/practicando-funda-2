package com.docseeker.Appointment.domain.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "appointments")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Appointment {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(name = "date")
  private String date;

  @Column(name = "start_time")
  private String startTime;

  @Column(name = "end_time")
  private String endTime;

  @Column(name = "doctor_id")
  private Integer doctorId;

  @Column(name = "patient_id")
  private Integer patientId;

}
