package com.github.gustavoflor.springwebfluxhandson.handler;

import com.github.gustavoflor.springwebfluxhandson.event.WeatherEvent;
import com.github.gustavoflor.springwebfluxhandson.service.WeatherEventService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class WeatherEventHandler {
    private final WeatherEventService weatherEventService;

    public Mono<ServerResponse> stream(ServerRequest request) {
        return ServerResponse.ok()
                .contentType(MediaType.TEXT_EVENT_STREAM)
                .body(weatherEventService.stream(), WeatherEvent.class);
    }
}
