package com.capgemini.wsb.mapper;
import com.capgemini.wsb.dto.VisitTO;
import com.capgemini.wsb.persistence.entity.VisitEntity;

import java.util.List;
import java.util.stream.Collectors;


public class VisitMapper {

        public static VisitTO toTO(VisitEntity entity) {
            VisitTO to = new VisitTO();
            to.setId(entity.getId());
            to.setDescription(entity.getDescription());
            to.setTime(entity.getTime());
            to.setDoctorName(entity.getDoctor().getFirstName() + " " + entity.getDoctor().getLastName());
            to.setPatientName(entity.getPatient().getFirstName() + " " + entity.getPatient().getLastName());
            return to;
        }

        public static VisitEntity toEntity(VisitTO to) {
            VisitEntity entity = new VisitEntity();
            entity.setId(to.getId());
            entity.setDescription(to.getDescription());
            entity.setTime(to.getTime());
            return entity;
        }

        public static List<VisitTO> toTOs(List<VisitEntity> entities) {
            return entities.stream().map(VisitMapper::toTO).collect(Collectors.toList());
        }
}
