package com.capgemini.wsb.service.impl;

import com.capgemini.wsb.dto.DoctorTO;
import com.capgemini.wsb.mapper.DoctorMapper;
import com.capgemini.wsb.persistence.dao.DoctorRepository;
import com.capgemini.wsb.persistence.entity.DoctorEntity;
import com.capgemini.wsb.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DoctorServiceImpl implements DoctorService {

    private final DoctorRepository doctorRepository;

    @Autowired
    public DoctorServiceImpl(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    @Override
    public DoctorTO findById(Long id) {
        DoctorEntity entity = doctorRepository.findById(id).orElse(null);
        return DoctorMapper.toTO(entity);
    }

    @Override
    public DoctorTO create(DoctorTO doctorTO) {
        DoctorEntity entity = DoctorMapper.toEntity(doctorTO);
        entity = doctorRepository.save(entity);
        return DoctorMapper.toTO(entity);
    }

    @Override
    public DoctorTO update(DoctorTO doctorTO) {
        DoctorEntity entity = DoctorMapper.toEntity(doctorTO);
        entity = doctorRepository.save(entity);
        return DoctorMapper.toTO(entity);
    }

    @Override
    public void delete(Long id) {
        doctorRepository.deleteById(id);
    }

    @Override
    public List<DoctorTO> findAll() {
        List<DoctorEntity> entities = doctorRepository.findAll();
        return DoctorMapper.toTOs(entities);
    }

    @Override
    public DoctorEntity findOne(Long id) {
        return doctorRepository.findById(id).orElse(null);
    }
}
