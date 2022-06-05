package ua.com.alevel.facade.vaccinationdetails.impl;

import org.springframework.stereotype.Service;
import ua.com.alevel.facade.vaccinationdetails.RecordingFacade;
import ua.com.alevel.persistence.entity.vaccinationdetails.Recording;
import ua.com.alevel.service.user.DoctorCrudService;
import ua.com.alevel.service.user.PatientCrudService;
import ua.com.alevel.service.vaccinationdetails.RecordingService;
import ua.com.alevel.service.vaccinationdetails.VaccinationCenterService;
import ua.com.alevel.service.vaccinationdetails.VaccineService;
import ua.com.alevel.view.dto.request.RecordDto;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
public class RecordingFacadeImpl implements RecordingFacade {

    private final RecordingService recordingService;
    private final PatientCrudService patientCrudService;
    private final DoctorCrudService doctorCrudService;
    private final VaccinationCenterService vaccinationCenterService;
    private final VaccineService vaccineService;

    public RecordingFacadeImpl(RecordingService recordingService, PatientCrudService patientCrudService, DoctorCrudService doctorCrudService, VaccinationCenterService vaccinationCenterService, VaccineService vaccineService) {
        this.recordingService = recordingService;
        this.patientCrudService = patientCrudService;
        this.doctorCrudService = doctorCrudService;
        this.vaccinationCenterService = vaccinationCenterService;
        this.vaccineService = vaccineService;
    }

    @Override
    public Recording create(RecordDto recordDto) {
        Recording record = new Recording();
        patientCrudService.findById(recordDto.getPatientId()).ifPresent((patient) -> {
            patient.setFirstName(recordDto.getFirstName());
            patient.setLastName(recordDto.getLastName());
            patient.setDateOfBirth(LocalDate.parse(recordDto.getBirthday()));
            patientCrudService.update(patient);
            record.setPatient(patient);
        } );
        vaccinationCenterService.findById(recordDto.getVaccinationCenterId()).ifPresent(record::setVaccinationCenter);
        doctorCrudService.findById(recordDto.getDoctorId()).ifPresent(record::setDoctor);
        vaccineService.findById(recordDto.getVaccineId()).ifPresent(record::setVaccine);
        record.setTimeRecord(LocalDateTime.parse(recordDto.getSelectedDate() + "T" + recordDto.getSelectedTime()));
        System.out.println(record);
        return recordingService.create(record);
    }
}
