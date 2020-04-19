package com.garden.life.auth.service.impl;

import com.garden.life.auth.service.JwtUserService;
import com.garden.life.commons.service.UserService;
import org.apache.dubbo.config.annotation.Reference;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * @author lenvaco
 * @date 2020/4/19 13:57
 */
@Service(version = "${services.versions.jwt.user.v1}",timeout = 50000)
public class JwtUserServiceImpl implements JwtUserService {

	@Reference(version = "${services.versions.user.v1}", lazy = true, timeout = 3000)
	private UserService userService;

	@Override
	public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
		return null;
	}
}
