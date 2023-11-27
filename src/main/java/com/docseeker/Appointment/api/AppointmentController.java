package com.docseeker.Appointment.api;

import com.docseeker.Appointment.domain.model.entity.Appointment;
import com.docseeker.Appointment.domain.service.AppointmentService;
import com.docseeker.Appointment.mapping.AppointmentMapper;
import com.docseeker.Appointment.resource.AppointmentResource;
import com.docseeker.Appointment.resource.CreateAppointmentResource;
import com.docseeker.Appointment.resource.UpdateAppointmentResource;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin()
@RequestMapping("api/v1/appointments")
@AllArgsConstructor
public class AppointmentController {

  private AppointmentService appointmentService;
  private AppointmentMapper mapper;

  @Operation(summary = "Get all")
  @GetMapping
  public List<Appointment> fetchAll() {
    return appointmentService.fetchAll();
  }


  @PostMapping
  public AppointmentResource save(@RequestBody CreateAppointmentResource resource) {
    return mapper.toResource(appointmentService.save(mapper.toModel(resource)));
  }

  @GetMapping("{id}")
  public AppointmentResource fetchId(@PathVariable Integer id) {
    //return studentService.fetchById(id).get();
    return this.mapper.toResource(appointmentService.fetchById(id).get());
  }

  @PutMapping("{id}")
  public ResponseEntity<AppointmentResource> update(@PathVariable Integer id,
                                                    @RequestBody UpdateAppointmentResource resource){
    if (id.equals(resource.getId())) {
      AppointmentResource studentResource = mapper.toResource(
        appointmentService.update( mapper.toModel(resource) ) );
      return new ResponseEntity<>(studentResource, HttpStatus.OK);
    } else {
      return ResponseEntity.badRequest().build();
    }
  }

  @Operation(summary = "Delete by Id")
  @DeleteMapping("{id}")
  public ResponseEntity<?> delete(@PathVariable Integer id) {
    if(appointmentService.deleteById(id)){
      return ResponseEntity.ok().build(); //Devolver de forma directa - lambda
      //return new ResponseEntity<>(HttpStatus.OK); //Devoluicon con instanciación
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  @Operation(summary = "Get appointments by patient and doctor id")
  @GetMapping("patient/{patientId}/doctor/{doctorId}")
  public List<Appointment> fetchByPatientAndDoctorId(@PathVariable Integer patientId,
                                                     @PathVariable Integer doctorId) {
    return appointmentService.fetchByPatientAndDoctorId(patientId, doctorId);
  }

  @Operation(summary = "Get appointments by doctor id and date")
  @GetMapping("/doctor/{doctorId}/date/{date}")
  public List<Appointment> fetchByDoctorIdAndDate(@PathVariable Integer doctorId,
                                                  @PathVariable String date) {
    return appointmentService.fetchByDoctorIdAndDate(doctorId, date);
  }

  @Operation(summary = "Get appointments by patient id")
  @GetMapping("/patient/{patientId}")
  public List<Appointment> fetchByPatientId(@PathVariable Integer patientId) {
    return appointmentService.fetchByPatientId(patientId);
  }

  @Operation(summary = "Get appointments by doctor id")
    @GetMapping("/doctor/{doctorId}")
    public List<Appointment> fetchByDoctorId(@PathVariable Integer doctorId) {
        return appointmentService.fetchByDoctorId(doctorId);
    }
}
