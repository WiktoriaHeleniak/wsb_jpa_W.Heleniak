package com.capgemini.wsb.service.impl;

import com.capgemini.wsb.dto.PatientTO;
import com.capgemini.wsb.mapper.PatientMapper;
import com.capgemini.wsb.persistence.dao.PatientRepository;
import com.capgemini.wsb.persistence.dao.VisitRepository;
import com.capgemini.wsb.persistence.entity.PatientEntity;
import com.capgemini.wsb.persistence.entity.VisitEntity;
import com.capgemini.wsb.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@Service
@Transactional
public class PatientServiceImpl implements PatientService {

    private final PatientRepository patientRepository;

    @Autowired
    private final VisitRepository visitRepository;



    @Autowired
    public PatientServiceImpl(PatientRepository patientRepository, VisitRepository visitRepository) {
        this.patientRepository = patientRepository;
        this.visitRepository = visitRepository;
    }



    @Override
    public PatientTO findById(Long id) {
        PatientEntity entity = patientRepository.findById(id).orElse(null);
        return PatientMapper.toTO(entity);
    }

    @Override
    public PatientTO create(PatientTO patientTO) {
        PatientEntity entity = PatientMapper.toEntity(patientTO);
        entity = patientRepository.save(entity);
        return PatientMapper.toTO(entity);
    }

    @Override
    public PatientTO update(PatientTO patientTO) {
        PatientEntity entity = PatientMapper.toEntity(patientTO);
        entity = patientRepository.save(entity);
        return PatientMapper.toTO(entity);
    }

@Transactional
    @Override
    public void delete(Long PatientID) {
        PatientEntity entity = patientRepository.findById(PatientID).orElseThrow();
        Set<VisitEntity> visits = entity.getVisits();
        for (VisitEntity visit : visits) {
            visitRepository.delete(visit);
        }
    }

    @Override
    public List<PatientTO> findAll() {
        List<PatientEntity> entities = patientRepository.findAll();
        return PatientMapper.toTOs(entities);
    }

    @Override
    public PatientEntity findOne(long l) {
        return null;
    }

    @Override
    public List<PatientTO> findByLastName(String lastName) {
        List<PatientEntity> entities = patientRepository.findByLastName(lastName);
        return PatientMapper.toTOs(entities);
    }

    @Override
    public List<PatientTO> findByNumberOfVisits(int x) {
        List<PatientEntity> entities = patientRepository.findByNumberOfVisits(x);
        return PatientMapper.toTOs(entities);
    }
}

