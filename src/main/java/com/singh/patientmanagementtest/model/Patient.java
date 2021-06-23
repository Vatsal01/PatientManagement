package com.singh.patientmanagementtest.model;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Table(name = "patients")
@Entity
public class Patient implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long patientId;

    @NotNull (message = "first name can not be null")
    private String firstName;

    @NotNull (message = "surname  can not be null")
    private String surname;

    @NotNull (message = "date of birth can not be null")
    private Date dateOfBirth;

    @NotNull (message = "social security can not be null")
    private String socialSecurityNumber;

    @OneToMany(mappedBy="patient", cascade = CascadeType.ALL)
    List<Visit> visits = new ArrayList<>();



    public Patient(String firstName, String surname, Date dateOfBirth, String socialSecurityNumber) {
        this.firstName = firstName;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
        this.socialSecurityNumber = socialSecurityNumber;
    }

    public Patient() {

    }

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        patientId = patientId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getSocialSecurityNumber() {
        return socialSecurityNumber;
    }

    public void setSocialSecurityNumber(String socialSecurityNumber) {
        this.socialSecurityNumber = socialSecurityNumber;
    }



}
