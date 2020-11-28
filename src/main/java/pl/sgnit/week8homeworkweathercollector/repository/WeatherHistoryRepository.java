package pl.sgnit.week8homeworkweathercollector.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sgnit.week8homeworkweathercollector.model.WeatherHistory;

public interface WeatherHistoryRepository extends JpaRepository<WeatherHistory, Long> {
}
