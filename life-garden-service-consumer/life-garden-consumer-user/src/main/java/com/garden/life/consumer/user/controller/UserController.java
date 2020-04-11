package com.garden.life.consumer.user.controller;

import com.garden.life.commons.domain.User;
import com.garden.life.commons.service.UserService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lenvaco
 * @date 2020/3/29 1:35
 */
@RestController
public class UserController {

	@Reference(version = "${services.versions.user.v1}", lazy = true, timeout = 3000)
	private UserService userService;

	@GetMapping("/user")
	public User queryUser(){
		System.out.println(userService);
		return userService.queryUserByUsername("LittleCat");
	}
}
