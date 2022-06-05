package ua.com.alevel.persistence.repository.vaccinationdetails;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import ua.com.alevel.persistence.entity.vaccinationdetails.VaccinationCenter;
import ua.com.alevel.persistence.repository.BaseRepository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VaccinationCenterRepository extends BaseRepository<VaccinationCenter>,
        JpaSpecificationExecutor<VaccinationCenter> {

    Page<VaccinationCenter> findAll(Pageable pageable);

    List<VaccinationCenter> findAll();

    Optional<VaccinationCenter> findById(Long id);

    List<VaccinationCenter> findDistinctVaccinationCenterByVaccinesIn(Iterable vaccines);
}
