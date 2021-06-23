package com.singh.patientmanagementtest.repository;


import com.singh.patientmanagementtest.model.Patient;
import com.singh.patientmanagementtest.model.Visit;
import org.springframework.data.repository.CrudRepository;

import java.sql.Date;
import java.util.List;

public interface VisitRepo extends CrudRepository<Visit, Long>{

     Visit findById( long visitId);
     List<Visit> findVisitsByPatient(Patient patient);
     List<Visit> findVisitsByPatientPatientId(final Long patientId);
     List<Visit> findVisitsByDate(Date date);
}
