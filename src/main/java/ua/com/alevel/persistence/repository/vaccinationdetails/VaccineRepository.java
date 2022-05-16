package ua.com.alevel.persistence.repository.vaccinationdetails;

import org.springframework.stereotype.Repository;
import ua.com.alevel.persistence.entity.vaccinationdetails.Vaccine;
import ua.com.alevel.persistence.repository.BaseRepository;

import java.util.List;

@Repository
public interface VaccineRepository extends BaseRepository<Vaccine> {

    List<Vaccine> findAll();
}
