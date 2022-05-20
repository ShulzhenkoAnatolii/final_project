package ua.com.alevel.service.vaccinationdetails;

import ua.com.alevel.persistence.entity.vaccinationdetails.Vaccine;
import ua.com.alevel.service.CrudService;

import java.util.List;
import java.util.Optional;

public interface VaccineService extends CrudService<Vaccine> {

    Optional<Vaccine> findById(Long id);

    List<Vaccine> findAll();
}
