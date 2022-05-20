package ua.com.alevel.service.vaccinationdetails.impl;

import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ua.com.alevel.persistence.entity.vaccinationdetails.VaccinationCenter;
import ua.com.alevel.persistence.entity.vaccinationdetails.Vaccine;
import ua.com.alevel.persistence.repository.vaccinationdetails.VaccinationCenterRepository;
import ua.com.alevel.persistence.repository.vaccinationdetails.VaccineRepository;
import ua.com.alevel.service.vaccinationdetails.VaccinationCenterService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class VaccinationCenterServiceImpl implements VaccinationCenterService {

    private final VaccinationCenterRepository repository;
    private final VaccineRepository vaccineRepository;

    public VaccinationCenterServiceImpl(VaccinationCenterRepository repository, VaccineRepository vaccineRepository) {
        this.repository = repository;
        this.vaccineRepository = vaccineRepository;
    }

    @Override
    public VaccinationCenter create(VaccinationCenter entity) {
        return null;
    }

    @Override
    public VaccinationCenter update(VaccinationCenter entity) {
        return null;
    }

    @Override
    public void delete(Long id) { }

    @Override
    public Page<VaccinationCenter> getPage(int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber - 1, pageSize);
        return repository.findAll(pageable);
    }

    @Override
    public Page<VaccinationCenter> getPage(int pageNumber, int pageSize, List<Vaccine> vaccines) {

        Pageable pageable = PageRequest.of(pageNumber - 1, pageSize);
        int start = (int) pageable.getOffset();

        List<VaccinationCenter> vaccinationCenters = repository.findAll()
                .stream()
                .filter(x -> x.getVaccines().stream().anyMatch(vaccines::contains))
                .toList();
        int end = Math.min((start + pageable.getPageSize()), vaccinationCenters.size());
        return new PageImpl<>(vaccinationCenters.subList(start, end), pageable, vaccinationCenters.size());
    }

    @Override
    public Optional<VaccinationCenter> findById(Long id) {
        return repository.findById(id);
    }

    public List<Vaccine> checkedVaccines (List<Long> vaccinesParam) {

        List<Vaccine> checkedVaccines = new ArrayList<>();
        List<Vaccine> vaccineList = vaccineRepository.findAll();

        if (vaccinesParam == null || vaccinesParam.isEmpty()) {
            checkedVaccines = vaccineList;
        } else {
            for (Long id : vaccinesParam) {
                vaccineRepository.findById(id).ifPresent(checkedVaccines::add);
            }
            for (Vaccine allVaccine : vaccineList) {
                for (Vaccine checkedVaccine : checkedVaccines) {
                    if (allVaccine.getId().equals(checkedVaccine.getId())) {
                        allVaccine.setFilter(true);
                        break;
                    }
                }
            }
        }
        return checkedVaccines;
    }
}
