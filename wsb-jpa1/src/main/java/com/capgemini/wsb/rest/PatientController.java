package com.capgemini.wsb.rest;

import com.capgemini.wsb.dto.PatientTO;
import com.capgemini.wsb.rest.exception.EntityNotFoundException;
import com.capgemini.wsb.service.PatientService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PatientController {

    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping("/patient/{id}")
    PatientTO findById(@PathVariable final Long id) {
        final PatientTO patient = patientService.findById(id);
        if (patient != null) {
            return patient;
        }
        throw new EntityNotFoundException(id);
    }

    @GetMapping("/patient/{id}/doctor")
    PatientTO findDoctorByPatientId(@PathVariable final Long id) {
        final PatientTO patient = patientService.findById(id);
        if (patient != null) {
            return patient;
        }
        throw new EntityNotFoundException(id);
    }

    @GetMapping("/patient/{id}/address")
    PatientTO findAddressByPatientId(@PathVariable final Long id) {
        final PatientTO patient = patientService.findById(id);
        if (patient != null) {
            return patient;
        }
        throw new EntityNotFoundException(id);
    }

    @GetMapping("/patient/{id}/visit")
    PatientTO findVisitByPatientId(@PathVariable final Long id) {
        final PatientTO patient = patientService.findById(id);
        if (patient != null) {
            return patient;
        }
        throw new EntityNotFoundException(id);
    }

    @GetMapping("/patient/{id}/prescription")
    PatientTO findPrescriptionByPatientId(@PathVariable final Long id) {
        final PatientTO patient = patientService.findById(id);
        if (patient != null) {
            return patient;
        }
        throw new EntityNotFoundException(id);
    }

    @GetMapping("/patient/{id}/medicine")
    PatientTO findMedicineByPatientId(@PathVariable final Long id) {
        final PatientTO patient = patientService.findById(id);
        if (patient != null) {
            return patient;
        }
        throw new EntityNotFoundException(id);
    }
}
