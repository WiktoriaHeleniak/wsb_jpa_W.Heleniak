package com.capgemini.wsb.service;

import com.capgemini.wsb.dto.VisitTO;
import com.capgemini.wsb.persistence.entity.VisitEntity;

import java.util.List;
import java.util.Optional;

public interface VisitService {
    VisitEntity saveVisit(VisitEntity visit);

    Optional<VisitEntity> getVisitById(Long id);

    List<VisitEntity> getAllVisits();

    void deleteVisit(Long id);

    VisitTO findById(Long id);
}
