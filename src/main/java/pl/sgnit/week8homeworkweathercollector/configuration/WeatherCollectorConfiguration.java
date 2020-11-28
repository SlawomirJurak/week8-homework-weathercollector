package pl.sgnit.week8homeworkweathercollector.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "weather")
public class WeatherCollectorConfiguration {

    public String getKey() {
        return Key;
    }

    public void setKey(String key) {
        Key = key;
    }

    private String Key;

}
