package ua.com.alevel.service.vaccinationdetails.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ua.com.alevel.persistence.entity.vaccinationdetails.Recording;
import ua.com.alevel.persistence.repository.vaccinationdetails.RecordingRepository;
import ua.com.alevel.service.vaccinationdetails.RecordingService;

@Service
public class RecordingServiceImpl implements RecordingService {

    private final RecordingRepository recordingRepository;

    public RecordingServiceImpl(RecordingRepository recordingRepository) {
        this.recordingRepository = recordingRepository;
    }

    @Override
    @Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
    public Recording create(Recording entity) {
        return recordingRepository.save(entity);
    }

    @Override
    public Recording update(Recording entity) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
