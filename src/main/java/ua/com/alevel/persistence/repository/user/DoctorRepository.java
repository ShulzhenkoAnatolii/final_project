package ua.com.alevel.persistence.repository.user;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import ua.com.alevel.persistence.entity.user.Doctor;
import ua.com.alevel.persistence.entity.vaccinationdetails.VaccinationCenter;

import java.util.List;

@Repository
public interface DoctorRepository extends UserRepository<Doctor> {

    Page<Doctor> findAllByVaccinationCenterId (Long id, Pageable pageable);

}
