package ua.com.alevel.persistence.repository.vaccinationdetails;

import org.springframework.stereotype.Repository;
import ua.com.alevel.persistence.entity.vaccinationdetails.Recording;
import ua.com.alevel.persistence.repository.BaseRepository;

@Repository
public interface RecordingRepository extends BaseRepository<Recording> {
}
