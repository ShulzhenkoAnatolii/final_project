package ua.com.alevel.service.user;

import org.springframework.security.core.Authentication;
import ua.com.alevel.persistence.entity.user.Patient;
import ua.com.alevel.service.CrudService;

public interface PatientCrudService extends CrudService<Patient> {

    public Authentication getCurrentUser();

    Patient findByEmail(String email);

    void save(Patient patient);
}
