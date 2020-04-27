package com.garden.life.auth.service.impl;


import com.garden.life.auth.beans.AuthenticationInfo;
import com.garden.life.auth.beans.JwtUser;
import com.garden.life.auth.service.JwtUserService;

import com.garden.life.commons.bean.UserDetailDTO;
import com.garden.life.commons.service.UserService;
import com.garden.life.commons.util.JwtTokenUtils;
import org.apache.dubbo.config.annotation.Reference;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import javax.annotation.PostConstruct;

/**
 * @author lenvaco
 * @date 2020/4/19 13:57
 */
@Service(version = "${services.versions.jwt.user.v1}",timeout = 50000)
public class JwtUserServiceImpl implements JwtUserService {

	@Reference(version = "${services.versions.user.v1}", lazy = true, timeout = 3000)
	private UserService userService;

	private JwtTokenUtils jwtTokenUtils;
	@PostConstruct
	private void init() {
		jwtTokenUtils  = new JwtTokenUtils();
	}
	@Override
	public UserDetails loadUserByUsername(String account) throws UsernameNotFoundException {

		return null;
	}
	@Override
	public AuthenticationInfo queryUserDetail(String account, String password) {
		UserDetailDTO userDetailDTO = userService.queryUserDetail(account, password);
		if (userDetailDTO == null){
			return null;
		}
		JwtUser jwtUser = new JwtUser(userDetailDTO);
		String token = jwtTokenUtils.generateToken(jwtUser);
		return new AuthenticationInfo(token, jwtUser);
	}
}
