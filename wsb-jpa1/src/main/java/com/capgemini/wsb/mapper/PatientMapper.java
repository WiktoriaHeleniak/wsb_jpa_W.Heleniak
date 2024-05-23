package com.capgemini.wsb.mapper;


import com.capgemini.wsb.dto.PatientTO;
import com.capgemini.wsb.dto.VisitTO;
import com.capgemini.wsb.persistence.entity.PatientEntity;
import com.capgemini.wsb.persistence.entity.VisitEntity;

import java.util.List;
import java.util.stream.Collectors;

public class PatientMapper {

    public static PatientTO toTO(PatientEntity entity) {
        PatientTO to = new PatientTO();
        to.setId(entity.getId());
        to.setFirstName(entity.getFirstName());
        to.setLastName(entity.getLastName());
        to.setTelephoneNumber(entity.getTelephoneNumber());
        to.setEmail(entity.getEmail());
        to.setPatientNumber(entity.getPatientNumber());
        to.setDateOfBirth(entity.getDateOfBirth());
        to.setVisits(entity.getVisits().stream().map(PatientMapper::toVisitTO).collect(Collectors.toList()));
        return to;
    }

    public static VisitTO toVisitTO(VisitEntity entity) {
        VisitTO to = new VisitTO();
        to.setId(entity.getId());
        to.setDescription(entity.getDescription());
        to.setTime(entity.getTime());
        to.setDoctorName(entity.getDoctor().getFirstName() + " " + entity.getDoctor().getLastName());
        to.setPatientName(entity.getPatient().getFirstName() + " " + entity.getPatient().getLastName());
        return to;
    }

    public static PatientEntity toEntity(PatientTO to) {
        PatientEntity entity = new PatientEntity();
        entity.setId(to.getId());
        entity.setFirstName(to.getFirstName());
        entity.setLastName(to.getLastName());
        entity.setTelephoneNumber(to.getTelephoneNumber());
        entity.setEmail(to.getEmail());
        entity.setPatientNumber(to.getPatientNumber());
        entity.setDateOfBirth(to.getDateOfBirth());
        return entity;
    }
    public static List<PatientTO> toTOs(List<PatientEntity> entities) {
        return entities.stream().map(PatientMapper::toTO).collect(Collectors.toList());
    }
}
