package ua.com.alevel.service.vaccinationdetails;

import org.springframework.data.domain.Page;
import ua.com.alevel.persistence.entity.vaccinationdetails.VaccinationCenter;
import ua.com.alevel.service.CrudService;

import java.util.Optional;

public interface VaccinationCenterService extends CrudService<VaccinationCenter> {

    Page<VaccinationCenter> getPage(int pageNumber, int pageSize);
    Optional<VaccinationCenter> findById(Long id);
}
