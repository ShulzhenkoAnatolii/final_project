package ua.com.alevel.cron;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ua.com.alevel.persistence.entity.api.CovidApiStatistics;
import ua.com.alevel.persistence.repository.api.CovidApiStatisticsRepository;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Objects;

@Service
//@EnableScheduling
public class CovidApiCron {

    @Value("${covid.api.url}")
    private String url;

    private LocalDate previousDay = LocalDate.now().minusDays(1);

    private final CovidApiStatisticsRepository covidApi;

    public CovidApiCron(CovidApiStatisticsRepository covidApi) {
        this.covidApi = covidApi;
    }

    @Scheduled(fixedDelay = 60000)
    public void askInformation() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<DataCovidDto> response = restTemplate.getForEntity(
                url + previousDay,
                DataCovidDto.class
        );
        if (response.getStatusCode().equals(HttpStatus.OK)){
            CovidApiStatistics apiStatistics = new CovidApiStatistics();
            apiStatistics.setData(Objects.requireNonNull(response.getBody()).getData());
            covidApi.save(apiStatistics);
        }
    }

    private static class DataCovidDto {

        HashMap<String, String> data;

        public HashMap<String, String> getData() {
            return data;
        }

        public void setData(HashMap<String, String> data) {
            this.data = data;
        }
    }
}





