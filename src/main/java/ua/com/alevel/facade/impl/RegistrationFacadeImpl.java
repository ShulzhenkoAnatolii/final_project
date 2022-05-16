package ua.com.alevel.facade.impl;

import org.springframework.stereotype.Service;
import ua.com.alevel.facade.RegistrationFacade;
import ua.com.alevel.persistence.entity.user.Patient;
import ua.com.alevel.service.user.PatientCrudService;
import ua.com.alevel.view.dto.request.AuthDto;

@Service
public class RegistrationFacadeImpl implements RegistrationFacade {

    private final PatientCrudService patientCrudService;

    public RegistrationFacadeImpl(PatientCrudService patientCrudService) {
        this.patientCrudService = patientCrudService;
    }

    @Override
    public void registration(AuthDto dto) {
        Patient patient = new Patient();
        patient.setEmail(dto.getEmail());
        patient.setPassword(dto.getPassword());
        patientCrudService.create(patient);
    }
}
