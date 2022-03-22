package io.ipme.neptunes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.ipme.neptunes.Model.User;
import io.ipme.neptunes.data.InMemoryDataProvider;

@SpringBootApplication
public class NeptunesApplication {

    public static void main(String[] args) {
        SpringApplication.run(NeptunesApplication.class, args);
    }
}
