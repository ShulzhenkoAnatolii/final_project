package ua.com.alevel.persistence.entity.user;

import lombok.Data;
import ua.com.alevel.persistence.entity.vaccinationdetails.Recording;
import ua.com.alevel.persistence.entity.vaccinationdetails.VaccinationCenter;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@DiscriminatorValue("DOCTOR")
public class Doctor extends User{

    private String firstName;
    private String lastName;
    private String patronymic;

    @ManyToOne()
    @JoinColumn(name = "vaccination_center_id", referencedColumnName = "id")
    private VaccinationCenter vaccinationCenter;

    @OneToMany(cascade = {CascadeType.ALL}, mappedBy = "doctor")
    private List<Recording> recording;

    public String getFullName() {
        return firstName + " " + lastName;
    }
}
