package com.capgemini.wsb.service;


import com.capgemini.wsb.dto.PatientTO;
import com.capgemini.wsb.persistence.dao.PatientRepository;
import com.capgemini.wsb.persistence.entity.PatientEntity;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface PatientService {
    PatientTO findById(final Long id);

    PatientTO create(PatientTO patientTO);


    PatientTO update(PatientTO patientTO);

    void delete(Long PatientID);

    List<PatientTO> findAll();

    PatientEntity findOne(long l);

    List<PatientTO> findByLastName(String lastName);

    List<PatientTO> findByNumberOfVisits(int x);

}
