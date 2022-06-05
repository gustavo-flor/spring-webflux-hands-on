package com.github.gustavoflor.springwebfluxhandson.service;

import com.github.gustavoflor.springwebfluxhandson.event.WeatherEvent;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.stream.Stream;

@Service
public class WeatherEventService {
    public Flux<WeatherEvent> stream() {
        Flux<Long> interval = Flux.interval(Duration.ofSeconds(1));
        Flux<WeatherEvent> events = Flux.fromStream(Stream.generate(WeatherEvent::now));
        return Flux.zip(events, interval, (key, value) -> key);
    }
}
