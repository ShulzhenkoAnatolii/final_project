package ua.com.alevel.facade.user.impl;

import org.springframework.stereotype.Service;
import ua.com.alevel.facade.user.PatientFacade;
import ua.com.alevel.persistence.entity.user.Patient;
import ua.com.alevel.persistence.entity.util.SexType;
import ua.com.alevel.service.user.PatientCrudService;
import ua.com.alevel.view.dto.request.PatientDto;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
public class PatientFacadeImpl implements PatientFacade {

    private final PatientCrudService patientCrudService;

    public PatientFacadeImpl(PatientCrudService patientCrudService) {
        this.patientCrudService = patientCrudService;
    }

    @Override
    public void update(PatientDto patientDto, String email) {
        Patient patient = patientCrudService.findByEmail(email);
        if (patient != null) {
            patient.setFirstName(patientDto.getFirstName());
            patient.setLastName(patientDto.getLastName());
            patient.setPatronymic(patientDto.getPatronymic());
            patient.setDateOfBirth(LocalDate.parse(patientDto.getDateOfBirth()));
            patient.setSexType(SexType.valueOf(patientDto.getSexType()));
            patient.setUpdated(LocalDateTime.now());
            patientCrudService.update(patient);
        }
    }

    @Override
    public Patient findByEmail(String email) {
        return patientCrudService.findByEmail(email);
    }

}
