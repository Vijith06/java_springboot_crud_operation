package com.codemagen.product.service.impl;

import com.codemagen.product.service.WeatherService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherServiceImpl implements WeatherService {

    private final RestTemplate restTemplate;

    // First API details: OpenWeatherMap
    private final String openWeatherApiUrl = "http://api.openweathermap.org/data/2.5/weather";
    private final String openWeatherApiKey = "f631684865aea9787efe3a4515cfbe3f";

    // Second API details: WeatherAPI
    private final String weatherApiUrl = "http://api.weatherapi.com/v1/current.json";
    private final String weatherApiKey = "f4d5361eff1c458b9a745936252804"; // Replace with your WeatherAPI key

    public WeatherServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public String getWeatherData(String city) {
        // OpenWeatherMap API request
        String openWeatherUrl = String.format("%s?q=%s&appid=%s", openWeatherApiUrl, city, openWeatherApiKey);
        ResponseEntity<String> openWeatherResponse = restTemplate.getForEntity(openWeatherUrl, String.class);

        // WeatherAPI request
        String weatherApiUrlFinal = String.format("%s?key=%s&q=%s", weatherApiUrl, weatherApiKey, city);
        ResponseEntity<String> weatherApiResponse = restTemplate.getForEntity(weatherApiUrlFinal, String.class);

        // Combine the results from both APIs into a simple JSON-like structure
        String combinedResponse = "{\n" +
                "  \"openWeatherData\": " + openWeatherResponse.getBody() + ",\n" +
                "  \"weatherApiData\": " + weatherApiResponse.getBody() + "\n" +
                "}";

        return combinedResponse;
    }
}
