package com.singh.patientmanagementtest.service;

import com.singh.patientmanagementtest.model.Visit;
import com.singh.patientmanagementtest.model.VisitType;

import java.sql.Date;
import java.util.List;

public interface VisitService {

    Visit addVisit(final Visit visit);

    void deleteVisit(final Long visitId);

    void deleteVisitsByPatientId(final long patientId);

    Visit updateVisit(final Long visitId, final Visit visit);

    List<Visit> getAllVisitsByPatientId(final Long patientId);

    List<Visit> getAllVisitsForDay(final Date date);

    List<Visit> getAllVisitsByPatientAndDate(final Long patientId, final Date date);

    List<Visit> getAllVisitsByPatientAndDateAndType(final Long patientId, final Date date, VisitType visitType);

    Iterable<Visit> getAllVisits();

    Visit getVisitByVisitId(Long visitId);

}
