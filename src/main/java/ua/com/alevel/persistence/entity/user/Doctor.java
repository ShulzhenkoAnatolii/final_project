package ua.com.alevel.persistence.entity.user;

import ua.com.alevel.persistence.entity.vaccinationdetails.Recording;
import ua.com.alevel.persistence.entity.vaccinationdetails.VaccinationCenter;

import javax.persistence.*;
import java.util.List;

@Entity
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

    public VaccinationCenter getVaccinationCenter() {
        return vaccinationCenter;
    }

    public void setVaccinationCenter(VaccinationCenter vaccinationCenter) {
        this.vaccinationCenter = vaccinationCenter;
    }

    public List<Recording> getRecording() {
        return recording;
    }

    public void setRecording(List<Recording> recording) {
        this.recording = recording;
    }
}
