package ua.com.alevel.service.api;

import org.springframework.stereotype.Service;
import ua.com.alevel.persistence.repository.api.CovidApiStatisticsRepository;

import java.util.HashMap;

@Service
public class CovidApiStatisticsService {

    private final CovidApiStatisticsRepository apiRepository;
    private Long id = 1L;

    public CovidApiStatisticsService(CovidApiStatisticsRepository apiRepository) {
        this.apiRepository = apiRepository;
    }

    public HashMap<String, String> getData(){
        return apiRepository.findById(id).get().getData();
    }

}
