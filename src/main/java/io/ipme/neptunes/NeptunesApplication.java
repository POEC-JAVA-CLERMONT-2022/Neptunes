package io.ipme.neptunes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.ipme.neptunes.Data.InMemoryUserDataProvider;
import io.ipme.neptunes.Model.User;

@SpringBootApplication
public class NeptunesApplication {

    public static void main(String[] args) {
        SpringApplication.run(NeptunesApplication.class, args);
    }
}
