package ua.com.alevel.persistence.entity.user;

import ua.com.alevel.persistence.entity.vaccinationdetails.Recording;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@DiscriminatorValue("PATIENT")
public class Patient extends User {

    private String firstName;
    private String lastName;
    private String patronymic;

    @Column(name = "date_of_birth")
    private LocalDateTime dateOfBirth;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "patient")
    private Recording recording;

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

    public LocalDateTime getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDateTime dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Recording getRecording() {
        return recording;
    }

    public void setRecording(Recording recording) {
        this.recording = recording;
    }
}
