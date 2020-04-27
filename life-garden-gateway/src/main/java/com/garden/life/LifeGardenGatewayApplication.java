package com.garden.life;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.reactive.ReactiveUserDetailsServiceAutoConfiguration;


@SpringBootApplication(scanBasePackages = {"com.garden.life"}, exclude = {ReactiveUserDetailsServiceAutoConfiguration.class})
public class LifeGardenGatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(LifeGardenGatewayApplication.class, args);
    }
}
