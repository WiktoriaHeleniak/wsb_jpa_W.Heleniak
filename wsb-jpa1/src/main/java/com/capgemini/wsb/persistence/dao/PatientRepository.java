package com.capgemini.wsb.persistence.dao;

import com.capgemini.wsb.persistence.entity.PatientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.time.LocalDate;
import java.util.Optional;

import static org.hibernate.loader.Loader.SELECT;

@Repository
public interface PatientRepository extends JpaRepository<PatientEntity, Long> {

    @Query("SELECT p from PatientEntity p where p.id = :id")
    Optional<PatientEntity> findById(@Param("id") Long id);

    @Query("SELECT p from PatientEntity p JOIN FETCH p.visits where p.lastName = :lastName")
    List<PatientEntity> findByLastName(@Param("lastName") String lastName);

    @Query("Select p from PatientEntity p where size (p.visits) > 0" )
    List<PatientEntity> findByNumberOfVisits(@Param("x") int x);


}
