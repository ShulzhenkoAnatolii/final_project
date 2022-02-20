package ua.com.alevel.persistence.repository.user;

import org.springframework.stereotype.Repository;
import ua.com.alevel.persistence.entity.user.Patient;

@Repository
public interface PatientRepository extends UserRepository<Patient> {
}
