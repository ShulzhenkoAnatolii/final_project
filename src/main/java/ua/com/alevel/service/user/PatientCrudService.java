package ua.com.alevel.service.user;

import org.springframework.security.core.Authentication;
import ua.com.alevel.persistence.entity.user.Patient;
import ua.com.alevel.service.CrudService;

import java.util.Optional;

public interface PatientCrudService extends CrudService<Patient> {

    public Authentication getCurrentUser();

    Optional<Patient> findById(Long id);

    Patient findByEmail(String email);

    void save(Patient patient);

    int getTheCurrentAgeOfThePatient(Patient patient);
}
