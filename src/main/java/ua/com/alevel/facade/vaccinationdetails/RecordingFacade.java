package ua.com.alevel.facade.vaccinationdetails;

import ua.com.alevel.persistence.entity.vaccinationdetails.Recording;
import ua.com.alevel.view.dto.request.RecordDto;

public interface RecordingFacade {

    Recording create(RecordDto dto);
}
