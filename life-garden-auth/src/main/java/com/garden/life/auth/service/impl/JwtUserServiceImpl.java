package com.garden.life.auth.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.garden.life.auth.service.JwtUserService;
import com.garden.life.commons.domain.User;
import com.garden.life.commons.service.MenuService;
import com.garden.life.commons.service.PermissionService;
import com.garden.life.commons.service.RoleService;
import com.garden.life.commons.service.UserService;
import org.apache.dubbo.common.bytecode.Wrapper;
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
	public UserDetails loadUserByUsername(String account) throws UsernameNotFoundException {
		QueryWrapper<User> queryWrapper = new QueryWrapper<User>().eq("account", account);
		User user = userService.getOne()
		return null;
	}
}
