package com.garden.life.provider.user;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.apache.dubbo.container.Main;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author lenvaco
 * @date 2020/3/28 21:36
 */
@SpringBootApplication
@EnableDubbo
@MapperScan(basePackages = "com.garden.life.commons.mapper")
public class LifeGardenUserProviderApplication {
	public static void main(String[] args) {
		SpringApplication.run(LifeGardenUserProviderApplication.class, args);
		Main.main(args);
	}
}
