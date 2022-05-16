package ua.com.alevel.service.user;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ua.com.alevel.persistence.entity.user.Doctor;
import ua.com.alevel.persistence.entity.vaccinationdetails.VaccinationCenter;
import ua.com.alevel.service.CrudService;

public interface DoctorCrudService extends CrudService<Doctor> {

    Page<Doctor> findAllByVaccinationCenterId(Long id, Pageable pageable);

    Page<Doctor> getPage(int pageNumber, int pageSize);

    Page<Doctor> getDoctorsPageByVaccinationCenter(VaccinationCenter vaccinationCenter, Integer pageNumber, Integer pageSize);
}
