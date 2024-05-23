package com.capgemini.wsb.mapper;
import com.capgemini.wsb.dto.DoctorTO;
import com.capgemini.wsb.dto.VisitTO;
import com.capgemini.wsb.persistence.entity.DoctorEntity;
import com.capgemini.wsb.persistence.entity.VisitEntity;

import java.util.List;
import java.util.stream.Collectors;

public class DoctorMapper {

    public static DoctorTO toTO(DoctorEntity entity) {
        DoctorTO to = new DoctorTO();
        to.setId(entity.getId());
        to.setDoctorNumber(entity.getDoctorNumber());
        to.setEmail(entity.getEmail());
        to.setFirstName(entity.getFirstName());
        to.setLastName(entity.getLastName());
        to.setSpecialization(entity.getSpecialization());
        to.setTelephoneNumber(entity.getTelephoneNumber());
        to.setVisits(entity.getVisits().stream().map(DoctorMapper::toVisitTO).collect(Collectors.toList()));
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

    public static DoctorEntity toEntity(DoctorTO to) {
        DoctorEntity entity = new DoctorEntity();
        entity.setId(to.getId());
        entity.setDoctorNumber(to.getDoctorNumber());
        entity.setEmail(to.getEmail());
        entity.setFirstName(to.getFirstName());
        entity.setLastName(to.getLastName());
        entity.setSpecialization(to.getSpecialization());
        entity.setTelephoneNumber(to.getTelephoneNumber());
        return entity;
    }

    public static List<DoctorTO> toTOs(List<DoctorEntity> entities) {
        return entities.stream().map(DoctorMapper::toTO).collect(Collectors.toList());
    }
}

