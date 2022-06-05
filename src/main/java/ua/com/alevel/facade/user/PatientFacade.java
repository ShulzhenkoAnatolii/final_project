package ua.com.alevel.facade.user;

import ua.com.alevel.persistence.entity.user.Patient;
import ua.com.alevel.view.dto.request.PatientDto;

public interface PatientFacade {

    void update(PatientDto patientDto, String email);

    Patient findByEmail(String email);
}
