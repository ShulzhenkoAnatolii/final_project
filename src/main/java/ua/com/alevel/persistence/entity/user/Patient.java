package ua.com.alevel.persistence.entity.user;

import ua.com.alevel.persistence.entity.vaccinationdetails.Recording;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;

@Entity
@DiscriminatorValue("PATIENT")
public class Patient extends User {

    private String firstName;
    private String lastName;
    private String patronymic;

    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "patient")
    private Recording recording;

    @Transient
    public String getFullName() {
        return firstName + " " + lastName + " " + patronymic;
    }

    @Transient
    public int getCurrentAge() {
        return Period.between(dateOfBirth, LocalDate.from(LocalDateTime.now())).getYears();
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Recording getRecording() {
        return recording;
    }

    public void setRecording(Recording recording) {
        this.recording = recording;
    }
}
