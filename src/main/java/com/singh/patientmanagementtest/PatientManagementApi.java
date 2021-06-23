package com.singh.patientmanagementtest;

import com.singh.patientmanagementtest.model.Patient;
import com.singh.patientmanagementtest.model.Visit;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;


//swaggerUI: http://localhost:9090/swagger-ui/#/patient-management-controller
// API : http://localhost:9090/
public interface PatientManagementApi {


    @ApiOperation(value = "there is no operation available here")
    @RequestMapping(value="/", method = RequestMethod.GET)
    public String showIndex();

    @ApiOperation(value = "provides the full list of available patients")
    @RequestMapping(value="/getAllPatients", method = RequestMethod.GET)
    public List<Patient> getAllPatients();

    @ApiOperation(value = "get all visits in the system")
    @RequestMapping(value="/getAllVisits", method = RequestMethod.GET)
    public List<Visit> getAllVisits();

    @ApiOperation(value = "provides the patient for given patient id")
    @ApiParam(name = "patientId", value = "patient id", example = "11111111")
    @RequestMapping(value="/getPatientById", method = RequestMethod.GET)
    public Patient getPatientById(Long patientId);

    @ApiOperation(value = "provides the visit for given visit id")
    @ApiParam(name = "visitId", value = "visit id", example = "11111111")
    @RequestMapping(value="/getVisitById", method = RequestMethod.GET)
    public Visit getVisitById(Long visitId);

    @ApiOperation(value = "creates a patient with patient object")
    @ApiParam(name = "patient", value = "patient object")
    @RequestMapping(value="/createPatient", method = RequestMethod.POST, consumes = "application/json")
    public String createPatient(@Valid @RequestBody final Patient patient);

    @ApiOperation(value = "creates a visit for a visit object")
    @ApiParam(name = "visit", value = "visit object")
    @RequestMapping(value="/createVisit", method = RequestMethod.POST, consumes = "application/json")
    public String createVisit(@Valid @RequestBody final Visit visit);

    @ApiOperation(value = "get all visits for a patient with patient id")
    @ApiParam(name = "patient_id", value = "patient id")
    @RequestMapping(value="/getVisitsByPatientId", method = RequestMethod.GET)
    public List<Visit> getVisitsByPatientId(@RequestParam(value = "patient_id") @NotNull Long patientId);


}
