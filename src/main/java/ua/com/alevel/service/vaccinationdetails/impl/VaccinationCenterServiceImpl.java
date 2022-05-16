package ua.com.alevel.service.vaccinationdetails.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ua.com.alevel.persistence.entity.vaccinationdetails.VaccinationCenter;
import ua.com.alevel.persistence.repository.vaccinationdetails.VaccinationCenterRepository;
import ua.com.alevel.service.vaccinationdetails.VaccinationCenterService;

import java.util.Optional;

@Service
public class VaccinationCenterServiceImpl implements VaccinationCenterService {

    private final VaccinationCenterRepository repository;

    public VaccinationCenterServiceImpl(VaccinationCenterRepository repository) {
        this.repository = repository;
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
    public void delete(Long id) {

    }
    @Override
    public Page<VaccinationCenter> getPage(int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber - 1, pageSize);
        return repository.findAll(pageable);
    }

    @Override
    public Optional<VaccinationCenter> findById(Long id) {

        return repository.findById(id);
    }
}
