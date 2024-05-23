package com.capgemini.wsb.service.impl;

import com.capgemini.wsb.dto.VisitTO;
import com.capgemini.wsb.mapper.VisitMapper;
import com.capgemini.wsb.persistence.entity.VisitEntity;
import com.capgemini.wsb.persistence.dao.VisitRepository;
import com.capgemini.wsb.service.VisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VisitServiceImpl implements VisitService {

    private final VisitRepository visitRepository;

    @Autowired
    public VisitServiceImpl(VisitRepository visitRepository) {
        this.visitRepository = visitRepository;
    }

    @Override
    public VisitEntity saveVisit(VisitEntity visit) {
        return visitRepository.save(visit);
    }

    @Override
    public Optional<VisitEntity> getVisitById(Long id) {
        return visitRepository.findById(id);
    }

    @Override
    public List<VisitEntity> getAllVisits() {
        return visitRepository.findAll();
    }

    @Override
    public void deleteVisit(Long id) {
        visitRepository.deleteById(id);
    }

    @Override
    public VisitTO findById(Long id) {
        return VisitMapper.toTO(visitRepository.findById(id).get());
    }
}
