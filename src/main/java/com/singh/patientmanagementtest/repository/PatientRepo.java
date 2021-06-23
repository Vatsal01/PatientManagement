package com.singh.patientmanagementtest.repository;



import com.singh.patientmanagementtest.model.Patient;
import org.springframework.data.repository.CrudRepository;


public interface PatientRepo extends CrudRepository <Patient, Long>{

   Patient findById(long id);
   Patient findPatientBySocialSecurityNumber(String securityNumber);

}
