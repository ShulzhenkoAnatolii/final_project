package ua.com.alevel.persistence.repository.vaccinationdetails;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import ua.com.alevel.persistence.entity.vaccinationdetails.VaccinationCenter;
import ua.com.alevel.persistence.repository.BaseRepository;

import java.util.Optional;

@Repository
public interface VaccinationCenterRepository extends BaseRepository<VaccinationCenter> {

    Page<VaccinationCenter> findAll(Pageable pageable);

    Optional<VaccinationCenter> findById(Long id);
}
