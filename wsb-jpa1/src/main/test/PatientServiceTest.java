package com.capgemini.wsb.service;

import com.capgemini.wsb.dto.PatientTO;
import com.capgemini.wsb.persistence.dao.PatientRepository;
import com.capgemini.wsb.persistence.dao.VisitRepository;
import com.capgemini.wsb.persistence.dao.DoctorRepository;
import com.capgemini.wsb.persistence.entity.DoctorEntity;
import com.capgemini.wsb.persistence.entity.PatientEntity;
import com.capgemini.wsb.persistence.entity.VisitEntity;
import com.capgemini.wsb.persistence.enums.Specialization;
import com.capgemini.wsb.service.impl.PatientServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PatientServiceTest {

    @Autowired
    private PatientServiceImpl patientService;

    @Autowired
    private VisitRepository visitRepository;

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private DoctorRepository DoctorRepository;

    @Transactional
    @Test
    public void testShouldDeletePatientAndCascadeDeleteVisits() {
        PatientEntity patient = new PatientEntity();
        patient.setFirstName("Jane");
        patient.setLastName("Doe");
        patient.setDateOfBirth(LocalDate.of(1990, 2, 2));
        patient.setEmail("jane.doe@example.com");
        patient.setPatientNumber("P654321");
        patient.setTelephoneNumber("987654321");

        patientRepository.save(patient);

        DoctorEntity doctor = new DoctorEntity();
        doctor.setFirstName("John");
        doctor.setLastName("Smith");
        doctor.setEmail("john.smith@example.com");
        doctor.setDoctorNumber("D123456");
        doctor.setSpecialization(Specialization.NEUROLOGY);
        doctor.setTelephoneNumber("1234567890");

        DoctorRepository.save(doctor);

        VisitEntity visit = new VisitEntity();
        visit.setDescription("Checkup");
        visit.setDoctor(doctor);
        visit.setPatient(patient);
        visit.setVisitDate(LocalDateTime.of(2023, Month.MAY, 5, 10, 0));
        visit.setTime(LocalDateTime.of(2023, Month.MAY, 5, 10, 0));

        visitRepository.save(visit);

        // when
        patientService.delete(patient.getId());

        // then
        assertThat(patientRepository.findById(patient.getId())).isEmpty();
        assertThat(visitRepository.findById(visit.getId())).isEmpty();
    }

    @Transactional
    @Test
    public void testShouldFindPatientById() {
        // given
        PatientEntity patient = new PatientEntity();
        patient.setFirstName("Jane");
        patient.setLastName("Doe");
        patient.setDateOfBirth(LocalDate.of(1990, 2, 2));
        patient.setEmail("jane.doe@example.com");
        patient.setPatientNumber("P654321");
        patient.setTelephoneNumber("987654321");
        patient = patientRepository.save(patient);

        // when
        PatientTO patientTO = patientService.findById(patient.getId());

        // then
        assertThat(patientTO).isNotNull();
        assertThat(patientTO.getId()).isEqualTo(patient.getId());
        assertThat(patientTO.getFirstName()).isEqualTo("Jane");
        assertThat(patientTO.getLastName()).isEqualTo("Doe");
        assertThat(patientTO.getDateOfBirth()).isEqualTo(LocalDate.of(1990, 2, 2));
    }

    @Transactional
    @Test
    public void testShouldFindAllVisitsByPatientId() {
        PatientEntity patient = new PatientEntity();
        patient.setFirstName("Jane");
        patient.setLastName("Doe");
        patient.setDateOfBirth(LocalDate.of(1990, 2, 2));
        patient.setEmail("jane.doe@example.com");
        patient.setPatientNumber("P654321");
        patient.setTelephoneNumber("987654321");

        patientRepository.save(patient);

        DoctorEntity doctor = new DoctorEntity();
        doctor.setFirstName("John");
        doctor.setLastName("Smith");
        doctor.setEmail("john.smith@example.com");
        doctor.setDoctorNumber("D123456");
        doctor.setSpecialization(Specialization.NEUROLOGY);
        doctor.setTelephoneNumber("1234567890");

        DoctorRepository.save(doctor);

        VisitEntity visit = new VisitEntity();
        visit.setDescription("Checkup");
        visit.setDoctor(doctor);
        visit.setPatient(patient);
        visit.setVisitDate(LocalDateTime.of(2023, Month.MAY, 5, 10, 0));
        visit.setTime(LocalDateTime.of(2023, Month.MAY, 5, 10, 0));

        visitRepository.save(visit);

        // when
        List<VisitEntity> visits = visitRepository.findAllByPatientId(patient.getId());

        // then
        assertThat(visits).isNotEmpty();
        assertThat(visits).hasSize(1);
        assertThat(visits.get(0).getId()).isEqualTo(visit.getId());
    }
    }

