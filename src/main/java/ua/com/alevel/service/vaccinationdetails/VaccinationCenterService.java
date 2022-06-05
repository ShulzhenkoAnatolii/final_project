package ua.com.alevel.service.vaccinationdetails;

import org.springframework.data.domain.Page;
import ua.com.alevel.persistence.entity.vaccinationdetails.VaccinationCenter;
import ua.com.alevel.persistence.entity.vaccinationdetails.Vaccine;
import ua.com.alevel.service.CrudService;

import java.util.List;
import java.util.Optional;

public interface VaccinationCenterService extends CrudService<VaccinationCenter> {

    Page<VaccinationCenter> getPage(int pageNumber, int pageSize);

    Page<VaccinationCenter> getPage(int pageNumber, int pageSize, List<Vaccine> vaccines);

    Optional<VaccinationCenter> findById(Long id);

    List<VaccinationCenter> findAll();

    List<Vaccine> checkedVaccines(List<Long> vaccinesParam);
}
