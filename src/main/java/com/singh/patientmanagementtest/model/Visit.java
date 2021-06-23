package com.singh.patientmanagementtest.model;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;
import java.util.List;

@Table(name = "visits")
@Entity
// ensuring all the times are converted to CEST before persistence
public class Visit implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long visitId;

    @NotNull (message = "date of visit can not be null")
    private Date date;

    @NotNull (message = "start time of visit can not be null")
    private Time startTime;

    @NotNull (message = "end time of visit can not be null")
    private Time endTime;

    @NotNull (message = "visit type can not be null")
    private String visitType;

    //@NotNull (message = "patient id can not be null")
    @ManyToOne
    @JoinColumn(name ="FK_patientId")
    private Patient patient;

    // patientId : add index for faster query


    public Visit(Date date, Time startTime, Time endTime,  String visitType, Patient patient) {
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.visitType = visitType;
        this.patient = patient;
        //this.patient.getVisits().add(this);
    }

    public Visit() {

    }

    public Long getVisitId() {
        return visitId;
    }

    public void setVisitId(Long visitId) {
        this.visitId = visitId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getStartTime() {
        return startTime;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    public Time getEndTime() {
        return endTime;
    }

    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }


    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public String getVisitType() {
        return visitType;
    }

    public void setVisitType(String visitType) {
        this.visitType = visitType;
    }
}
