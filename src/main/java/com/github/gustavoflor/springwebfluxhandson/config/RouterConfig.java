package com.github.gustavoflor.springwebfluxhandson.config;

import com.github.gustavoflor.springwebfluxhandson.handler.WeatherEventHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;

@Configuration
public class RouterConfig {
    @Bean
    public RouterFunction<?> routes(WeatherEventHandler weatherEventHandler) {
        return RouterFunctions.route(RequestPredicates.GET("/weather-events"), weatherEventHandler::stream);
    }
}
