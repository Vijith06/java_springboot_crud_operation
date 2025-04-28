package com.codemagen.product.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class WeatherResponse {

    private Object openWeatherMapData;
    private Object weatherApiData;

}
