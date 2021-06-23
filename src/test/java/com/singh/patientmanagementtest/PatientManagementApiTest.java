package com.singh.patientmanagementtest;

import com.singh.patientmanagementtest.model.Patient;
import com.singh.patientmanagementtest.model.Visit;
import com.singh.patientmanagementtest.model.VisitType;
import com.singh.patientmanagementtest.service.impl.PatientServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Time;
import java.util.Date;
import java.text.SimpleDateFormat;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class PatientManagementApiTest {

    @InjectMocks
    PatientServiceImpl patientService;

    @BeforeEach
    void setUp() {
    }


    @Test
    void createPatient() {
        Patient patientAdded = prepareTestPatient();
        assertNotNull(patientAdded);
    }

    @Test
    void createVisit() {
    }

    @Test
    void getVisitsByPatientId() {
    }

    @Test
    void getAllVisits() {
    }

    @Test
    public void testSubjectViewNativeRepositoryBefore() {

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = format.format(new Date());
        System.out.println(dateString);
    }

    private Patient prepareTestPatient()
    {
        Patient patient=new  Patient("vatsal", "singh", new java.sql.Date(21212L), "social-securitty-number");
        patient.setPatientId(1L);
        return patient;
    }

    private Visit prepareTestVisit()
    {
        Patient patient=prepareTestPatient();
        Visit visit=new Visit(new java.sql.Date(2121212L), new Time(2121212L), new Time(2121212L), VisitType.DOCTOR.name(),  patient);
        visit.setVisitId(2L);
        return visit;
    }

}