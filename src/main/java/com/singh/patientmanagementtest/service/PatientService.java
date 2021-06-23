package com.singh.patientmanagementtest.service;

import com.singh.patientmanagementtest.model.Patient;

import java.util.List;

public interface PatientService {

     Patient addPatient(final Patient patient);

     Patient updatePatient(final Patient patient);

     void deletePatient(final Long patientId);

     Iterable<Patient> getAllPatients();

     Iterable<Patient> getAllPatientByPatientIds(final List<Long> patientIds);

     Patient getPatientByPatientId(final Long patientId);


}
