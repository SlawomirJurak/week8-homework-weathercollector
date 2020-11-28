package pl.sgnit.week8homeworkweathercollector.service;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import pl.sgnit.week8homeworkweathercollector.configuration.WeatherCollectorConfiguration;
import pl.sgnit.week8homeworkweathercollector.model.WeatherHistory;
import pl.sgnit.week8homeworkweathercollector.repository.WeatherHistoryRepository;

@Component
public class WeatherCollector {

    private final WeatherCollectorConfiguration weatherCollectorConfiguration;
    private final WeatherHistoryRepository weatherHistoryRepository;

    @Autowired
    public WeatherCollector(WeatherCollectorConfiguration weatherCollectorConfiguration, WeatherHistoryRepository weatherHistoryRepository) {
        this.weatherCollectorConfiguration = weatherCollectorConfiguration;
        this.weatherHistoryRepository = weatherHistoryRepository;
    }

    @Scheduled(cron = "0 * 0/1 * * ?")
    public void collectWeather() {
        RestTemplate restTemplate = new RestTemplate();
        String key = weatherCollectorConfiguration.getKey();

        String response = restTemplate.getForObject(key,
                String.class);
        JSONObject jsonObject = new JSONObject(response);
        System.out.println("temp: " + jsonObject.getJSONObject("main").getBigDecimal("temp"));
        WeatherHistory weatherHistory = new WeatherHistory();
        weatherHistory.setTemperature(jsonObject.getJSONObject("main").getBigDecimal("temp"));
        weatherHistory.setResponse(response);
        weatherHistoryRepository.save(weatherHistory);
    }
}
