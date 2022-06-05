package com.github.gustavoflor.springwebfluxhandson.event;

import com.github.gustavoflor.springwebfluxhandson.model.Weather;
import lombok.Getter;

import java.time.LocalDateTime;

public record WeatherEvent(Weather weather, LocalDateTime dateTime) {
    public static WeatherEvent now() {
        return new WeatherEvent(Weather.now(), LocalDateTime.now());
    }
}
