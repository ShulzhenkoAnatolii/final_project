package ua.com.alevel.service.vaccinationdetails;

import ua.com.alevel.persistence.entity.vaccinationdetails.Vaccine;
import ua.com.alevel.service.CrudService;

import java.util.List;

public interface VaccineService extends CrudService<Vaccine> {

    List<Vaccine> findAll();
}
