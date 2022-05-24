package ua.com.alevel.service.user.impl;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ua.com.alevel.persistence.entity.user.Patient;
import ua.com.alevel.persistence.entity.util.RoleType;
import ua.com.alevel.persistence.entity.util.SexType;
import ua.com.alevel.persistence.repository.user.PatientRepository;
import ua.com.alevel.service.user.PatientCrudService;

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
        entity.setSexType(SexType.Not_specified);
        return patientRepository.save(entity);
    }

    @Override
    public Patient update(Patient entity) {
        return null;
    }

    @Override
    public void delete(Long id) { }

    public Authentication getCurrentUser() {
        return SecurityContextHolder.getContext().getAuthentication();
    }

    @Override
    public Patient findByEmail(String email) {
        return patientRepository.findByEmail(email);
    }

    @Override
    public void save(Patient patient) {
        patientRepository.save(patient);
    }
}
