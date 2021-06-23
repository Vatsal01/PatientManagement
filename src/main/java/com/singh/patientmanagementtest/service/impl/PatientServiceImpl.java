package com.singh.patientmanagementtest.service.impl;

import com.singh.patientmanagementtest.model.Patient;
import com.singh.patientmanagementtest.model.Visit;
import com.singh.patientmanagementtest.repository.PatientRepo;
import com.singh.patientmanagementtest.repository.VisitRepo;
import com.singh.patientmanagementtest.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    PatientRepo patientRepo;

    @Autowired
    VisitRepo visitRepo;

    @Override
    public Patient addPatient(Patient patient) {
        if(patient==null)
        {
            System.err.println("patient can not be null");
            return null;
        }
        return patientRepo.save(patient);
    }

    @Override
    public Patient updatePatient(Patient patient) {
        if(patient==null)
        {
            System.err.println("patient can not be null");
            return null;
        }
        return patientRepo.save(patient);
    }

    @Override
    public void deletePatient(Long patientId) {
        Optional<Patient> patientToBeDeleted = patientRepo.findById(patientId);
        if(patientToBeDeleted==null)
        {
            System.err.println("patient is not found in the DB, hence can not be deleted..");
        }
        List<Visit> visitsToBeDeleted = visitRepo.findVisitsByPatientPatientId(patientId);

        // deleting all patient related visits
        System.out.println("visits to be deleted for the deleted patient "+patientId+" are "+visitsToBeDeleted.toString());
        visitRepo.deleteAll(visitsToBeDeleted);

        // deleting the patient
        patientRepo.delete(patientToBeDeleted.get());
        System.out.println("patient is deleted with id:"+patientId);
    }

    @Override
    public Iterable<Patient> getAllPatients() {
        Iterable<Patient> patients = patientRepo.findAll();
        return patients;
    }

    @Override
    public Iterable<Patient> getAllPatientByPatientIds(List<Long> patientIds) {
        if(patientIds== null || patientIds.isEmpty())
        {
            System.err.println("can not find the patients for an empty or null list");
            return null;
        }
        return patientRepo.findAllById(patientIds);
    }

    @Override
    public Patient getPatientByPatientId(Long patientId) {
       if(!patientRepo.findById(patientId).isPresent())
       {
           return null;
       }
        return patientRepo.findById(patientId).get();
    }


}
