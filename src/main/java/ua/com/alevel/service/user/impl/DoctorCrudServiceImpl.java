package ua.com.alevel.service.user.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ua.com.alevel.persistence.entity.user.Doctor;
import ua.com.alevel.persistence.entity.util.RoleType;
import ua.com.alevel.persistence.entity.vaccinationdetails.VaccinationCenter;
import ua.com.alevel.persistence.repository.user.DoctorRepository;
import ua.com.alevel.service.user.DoctorCrudService;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorCrudServiceImpl implements DoctorCrudService {

    private final DoctorRepository doctorRepository;
    private final BCryptPasswordEncoder encoder;

    public DoctorCrudServiceImpl(DoctorRepository doctorRepository, BCryptPasswordEncoder encoder) {
        this.doctorRepository = doctorRepository;
        this.encoder = encoder;
    }

    @Override
    @Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
    public Doctor create(Doctor entity) {
        entity.setPassword(encoder.encode(entity.getPassword()));
        entity.setRoleType(RoleType.ROLE_DOCTOR);
        return doctorRepository.save(entity);
    }

    @Override
    public Doctor update(Doctor entity) {
        return null;
    }

    @Override
    public void delete(Long id) { }

    @Override
    public Optional<Doctor> findById(Long id) {
        return doctorRepository.findById(id);
    }

    @Override
    public Page<Doctor> findAllByVaccinationCenterId(Long id, Pageable pageable) {
        return doctorRepository.findAllByVaccinationCenterId(id, pageable);
    }

    @Override
    public Page<Doctor> getPage(int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber - 1, pageSize);
        return doctorRepository.findAll(pageable);
    }

    public Page<Doctor> getDoctorsPageByVaccinationCenter(VaccinationCenter vaccinationCenter, Integer pageNumber, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNumber - 1, pageSize);
        List<Doctor> doctors = vaccinationCenter.getDoctors();
        int start = (int) pageable.getOffset();
        int end = Math.min((start + pageable.getPageSize()), doctors.size());
        return new PageImpl<>(doctors.subList(start, end), pageable, doctors.size());
    }

    @Override
    public List<Doctor> findAll() {
        return doctorRepository.findAll();
    }
}
