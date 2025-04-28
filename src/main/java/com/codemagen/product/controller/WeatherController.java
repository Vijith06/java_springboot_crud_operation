package com.codemagen.product.controller;


import com.codemagen.product.contants.EndPointConstants;
import com.codemagen.product.service.WeatherService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static com.codemagen.product.contants.EndPointConstants.BASE_URL;

@RestController
@RequestMapping(value = BASE_URL, produces = MediaType.APPLICATION_JSON_VALUE)
@Api(value = "Api Controller", produces = MediaType.APPLICATION_JSON_VALUE)
public class WeatherController {

    private final WeatherService weatherService;

    @Autowired
    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping(value = EndPointConstants.WEATHER)
    public String getWeather(@RequestParam String city) {
        return weatherService.getWeatherData(city);
    }
}