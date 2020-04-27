package com.garden.life.consumer.user;

import org.apache.dubbo.container.Main;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

/**
 * @author lenvaco
 * @date 2020/3/29 1:39
 */
@SpringBootApplication
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class LifeGardenUserConsumerApplication {
	public static void main(String[] args) {
		SpringApplication.run(LifeGardenUserConsumerApplication.class, args);
		Main.main(args);
	}
}
