package ua.com.alevel.persistence.repository.api;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.com.alevel.persistence.entity.api.CovidApiStatistics;

@Repository
public interface CovidApiStatisticsRepository extends JpaRepository<CovidApiStatistics, Long> {
}
