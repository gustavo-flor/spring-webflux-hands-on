package com.github.gustavoflor.springwebfluxhandson.model;

import com.github.javafaker.Faker;

public record Weather(String temperature, String humidity, String windSpeed) {
    private static final Faker FAKER = new Faker();

    public static Weather now() {
        return new Weather(getTemperature(), getHumidity(), getWindSpeed());
    }

    private static String getWindSpeed() {
        return String.format("%s km/h", FAKER.number().numberBetween(80, 120));
    }

    private static String getHumidity() {
        return String.format("%s%%", FAKER.number().numberBetween(40, 50));
    }

    private static String getTemperature() {
        return String.format("%s C°", FAKER.number().numberBetween(20, 25));
    }
}
