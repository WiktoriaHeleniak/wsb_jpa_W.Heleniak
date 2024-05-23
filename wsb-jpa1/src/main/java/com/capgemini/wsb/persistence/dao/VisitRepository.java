package com.capgemini.wsb.persistence.dao;

import com.capgemini.wsb.persistence.entity.VisitEntity;
import com.capgemini.wsb.persistence.enums.Specialization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VisitRepository extends JpaRepository<VisitEntity, Long> {
    List<VisitEntity> findAllByPatientId(Long patientId);
    @Query("SELECT v from VisitEntity v where v.id = :PatientID")
    VisitEntity findByPatientID(String PatientID);

    @Query("SELECT v from VisitEntity v where v.doctor.id = :doctorID")
    List<VisitEntity> findByDoctorID(String doctorID);

    @Query("SELECT v from VisitEntity v where v.patient.id = :patientID")
    List<VisitEntity> findByPatientID(Long patientID);


}
