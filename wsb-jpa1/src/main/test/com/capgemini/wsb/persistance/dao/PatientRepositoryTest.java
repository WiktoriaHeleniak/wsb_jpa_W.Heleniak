package com.capgemini.wsb.persistence.dao;

import com.capgemini.wsb.persistence.entity.PatientEntity;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class PatientRepositoryTest {

    @Autowired
    private PatientRepository patientRepository;

    @Transactional
    @Test
    public void testFindById() {
        // given
        Long patientId = 1L;

        // when
        Optional<PatientEntity> patient = patientRepository.findById(patientId);

        // then
        assertThat(patient).isPresent();
        assertThat(patient.get().getId()).isEqualTo(patientId);
    }

    @Transactional
    @Test
    public void testFindByLastName() {
        // given
        String lastName = "Brown";

        // when
        List<PatientEntity> patients = patientRepository.findByLastName(lastName);

        // then
        assertThat(patients).isNotEmpty();
        assertThat(patients.get(0).getLastName()).isEqualTo(lastName);
    }

    @Transactional
    @Test
    public void testFindByNumberOfVisits() {
        // given
        int visitCount = 0;

        // when
        List<PatientEntity> patients = patientRepository.findByNumberOfVisits(visitCount);

        // then
        assertThat(patients).isNotEmpty();
        assertThat(patients.get(0).getVisits().size()).isGreaterThan(visitCount);
    }
}
