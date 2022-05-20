package ua.com.alevel.persistence.repository.vaccinationdetails;

import org.springframework.stereotype.Repository;
import ua.com.alevel.persistence.entity.vaccinationdetails.Vaccine;
import ua.com.alevel.persistence.repository.BaseRepository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VaccineRepository extends BaseRepository<Vaccine> {
    Optional<Vaccine> findById(Long id);

    List<Vaccine> findAll();
}
