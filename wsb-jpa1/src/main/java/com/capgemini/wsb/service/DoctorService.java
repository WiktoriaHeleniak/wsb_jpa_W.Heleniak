package com.capgemini.wsb.service;

import com.capgemini.wsb.dto.DoctorTO;
import com.capgemini.wsb.persistence.entity.DoctorEntity;

import java.util.List;

public interface DoctorService {
    DoctorTO findById(Long id);

    DoctorTO create(DoctorTO doctorTO);

    DoctorTO update(DoctorTO doctorTO);

    void delete(Long id);

    List<DoctorTO> findAll();

    DoctorEntity findOne(Long id);
}
