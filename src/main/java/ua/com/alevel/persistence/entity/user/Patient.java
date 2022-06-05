package ua.com.alevel.persistence.entity.user;

import lombok.Data;
import ua.com.alevel.persistence.entity.util.SexType;
import ua.com.alevel.persistence.entity.vaccinationdetails.Recording;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;

@Entity
@Data
@DiscriminatorValue("PATIENT")
public class Patient extends User {

    private String firstName;
    private String lastName;
    private String patronymic;

    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "patient")
    private Recording recording;

    @Enumerated(EnumType.STRING)
    @Column(name = "sex_type", nullable = false)
    private SexType sexType;

    public Patient() {
        super();
    }

    public String getFullName() {
        return firstName + " " + lastName + " " + patronymic;
    }

    public int getCurrentAge() {
        return Period.between(dateOfBirth, LocalDate.from(LocalDateTime.now())).getYears();
    }

}
