package ua.com.alevel.service.vaccinationdetails.impl;

import org.springframework.stereotype.Service;
import ua.com.alevel.persistence.entity.vaccinationdetails.Vaccine;
import ua.com.alevel.persistence.repository.vaccinationdetails.VaccineRepository;
import ua.com.alevel.service.vaccinationdetails.VaccineService;

import java.util.List;

@Service
public class VaccineServiceImpl implements VaccineService {

    private final VaccineRepository vaccineRepository;

    public VaccineServiceImpl(VaccineRepository vaccineRepository) {
        this.vaccineRepository = vaccineRepository;
    }

    @Override
    public Vaccine create(Vaccine entity) {
        return null;
    }

    @Override
    public Vaccine update(Vaccine entity) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<Vaccine> findAll() {
        return vaccineRepository.findAll();
    }
}
