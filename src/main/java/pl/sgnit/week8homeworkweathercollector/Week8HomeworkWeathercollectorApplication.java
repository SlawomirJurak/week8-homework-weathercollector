package pl.sgnit.week8homeworkweathercollector;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.scheduling.annotation.EnableScheduling;
import pl.sgnit.week8homeworkweathercollector.configuration.WeatherCollectorConfiguration;

@SpringBootApplication
@EnableScheduling
@EnableConfigurationProperties(WeatherCollectorConfiguration.class)
public class Week8HomeworkWeathercollectorApplication {

    public static void main(String[] args) {
        SpringApplication.run(Week8HomeworkWeathercollectorApplication.class, args);
    }

}
