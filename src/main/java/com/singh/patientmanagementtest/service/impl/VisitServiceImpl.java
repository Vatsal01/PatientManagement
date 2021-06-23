package com.singh.patientmanagementtest.service.impl;

import com.singh.patientmanagementtest.model.Patient;
import com.singh.patientmanagementtest.model.Visit;
import com.singh.patientmanagementtest.model.VisitType;
import com.singh.patientmanagementtest.repository.VisitRepo;
import com.singh.patientmanagementtest.service.VisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class VisitServiceImpl implements VisitService {

    @Autowired
    VisitRepo visitRepo;

    @Override
    public Visit addVisit(Visit visit) {
        if(visit==null)
        {
            System.err.println("visit can not be null");
            return null;
        }
        return visitRepo.save(visit);
    }

    @Override
    public void deleteVisit(Long visitId) {
       visitRepo.deleteById(visitId);
        System.out.println("visit is deleted for visiting id : "+visitId);
    }

    @Override
    public void deleteVisitsByPatientId(long patientId) {

        List<Visit> visitsToBeDeleted = visitRepo.findVisitsByPatientPatientId(patientId);

        // deleting all patient related visits
        System.out.println("visits to be deleted for the patient "+patientId+" are "+visitsToBeDeleted.toString());
        visitRepo.deleteAll(visitsToBeDeleted);

    }

    @Override
    public Visit updateVisit(Long visitId, Visit visit) {
        Optional<Visit> visitExisting = visitRepo.findById(visitId);

        if(visitExisting==null)
        {
            System.err.println("visit is not existing, so creating new");
            return visitRepo.save(visit);
        }
        Visit visitToSave=visitExisting.get();
        visitToSave.setDate(visit.getDate());
        visitToSave.setPatient(visit.getPatient());
        visitToSave.setVisitType(visit.getVisitType());
        visitToSave.setStartTime(visit.getStartTime());
        visitToSave.setEndTime(visit.getEndTime());

        return visitRepo.save(visit);
    }

    @Override
    public List<Visit> getAllVisitsByPatientId(Long patientId) {
        return visitRepo.findVisitsByPatientPatientId(patientId);
    }

    @Override
    public List<Visit> getAllVisitsForDay(Date date) {
        visitRepo.findVisitsByDate(date);
        return null;
    }

    @Override
    public List<Visit> getAllVisitsByPatientAndDate(Long patientId, Date date) {
        List<Visit> allVisitsForPatient = getAllVisitsByPatientId(patientId);
        List<Visit> visitsForDay=new ArrayList<>();
        for(Visit visit:allVisitsForPatient)
        {
            if(visit.getDate().equals(date))
            {
                visitsForDay.add(visit);
            }
        }
        return visitsForDay;
    }

    @Override
    public List<Visit> getAllVisitsByPatientAndDateAndType(Long patientId, Date date, VisitType visitType) {
        List<Visit> getVisitsForPatientAndDate=getAllVisitsByPatientAndDate(patientId,date);
        List<Visit> visitsOfType=new ArrayList<>();
        for(Visit visit:getVisitsForPatientAndDate)
        {
            if(visit.getVisitType().equals(visitType))
            {
                visitsOfType.add(visit);
            }
        }
        return visitsOfType;
    }

    @Override
    public Iterable<Visit> getAllVisits() {
       return visitRepo.findAll();
    }

    @Override
    public Visit getVisitByVisitId(Long visitId) {
       if(!visitRepo.findById(visitId).isPresent())
       {
           return null;
       }
        return visitRepo.findById(visitId).get();
    }
}
