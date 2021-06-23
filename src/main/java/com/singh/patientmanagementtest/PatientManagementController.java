package com.singh.patientmanagementtest;


import com.singh.patientmanagementtest.model.Patient;
import com.singh.patientmanagementtest.model.Visit;
import com.singh.patientmanagementtest.service.PatientService;
import com.singh.patientmanagementtest.service.VisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping(path = "/")
public class PatientManagementController implements PatientManagementApi{

    @Autowired
    PatientService patientService;

    @Autowired
    VisitService visitService;

    @Value("${spring.application.name}")
    private String appName;

    @Override
    public String showIndex() {
        return "Welcome to "+appName+", please use specific endpoint for your request";
    }

    @Override
    public List<Patient> getAllPatients() {

        return (List<Patient>) patientService.getAllPatients();
    }

    @Override
    public Patient getPatientById(@RequestParam(value = "patient_id") @NotNull final Long patientId) {
        return patientService.getPatientByPatientId(patientId);
    }

    @Override
    public Visit getVisitById(@RequestParam(value = "visit_id") @NotNull final Long visitId) {

        return visitService.getVisitByVisitId(visitId);
    }

    @Override
    public String createPatient(@Valid @RequestBody final Patient patient) {

        Patient patientCreated = patientService.addPatient(patient);
        return "new patient {id:"+patientCreated.getPatientId()+"} "+patientCreated.getFirstName()+" is created successfully";
    }


    @Override
    public String createVisit(@Valid @RequestBody final Visit visit) {

        Patient patientAvailable=patientService.getPatientByPatientId(visit.getPatient().getPatientId());
        if(patientAvailable==null)
        {
            return "patient is not existing in the Database, so no visit can be assigned";
        }
        Visit visitCreated=visitService.addVisit(visit);
        return "new visit for patient {id:"+visitCreated.getPatient()+"} on "+visitCreated.getDate()+" is created successfully";
    }

    @Override
    public List<Visit> getVisitsByPatientId(@RequestParam(value = "patient_id") @NotNull final Long patientId) {

       List<Visit> patientVisits = visitService.getAllVisitsByPatientId(patientId);
       if (patientVisits==null || patientVisits.isEmpty())
       {
           // log the patient not found here
           return null;
       }
       return patientVisits;
    }

    @Override
    public List<Visit> getAllVisits()
    {
        return (List<Visit>) visitService.getAllVisits();
    }


}
