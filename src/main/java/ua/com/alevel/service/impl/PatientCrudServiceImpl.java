package ua.com.alevel.service.impl;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ua.com.alevel.persistence.entity.user.Patient;
import ua.com.alevel.persistence.entity.util.RoleType;
import ua.com.alevel.persistence.repository.user.PatientRepository;
import ua.com.alevel.service.PatientCrudService;

@Service
public class PatientCrudServiceImpl implements PatientCrudService {

    private final PatientRepository patientRepository;
    private final BCryptPasswordEncoder encoder;

    public PatientCrudServiceImpl(PatientRepository patientRepository, BCryptPasswordEncoder encoder) {
        this.patientRepository = patientRepository;
        this.encoder = encoder;
    }

    @Override
    @Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
    public Patient create(Patient entity) {
        entity.setPassword(encoder.encode(entity.getPassword()));
        entity.setRoleType(RoleType.ROLE_PATIENT);
        return patientRepository.save(entity);
    }

    @Override
    public Patient update(Patient entity) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
