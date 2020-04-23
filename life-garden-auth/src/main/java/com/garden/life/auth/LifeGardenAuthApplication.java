package com.garden.life.auth;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.apache.dubbo.container.Main;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * @author lenvaco
 * @date 2020/4/19 13:43
 */
@SpringBootApplication
@EnableDubbo
public class LifeGardenAuthApplication {
	public static void main(String[] args) {
		SpringApplication.run(LifeGardenAuthApplication.class, args);
		Main.main(args);
	}
}
