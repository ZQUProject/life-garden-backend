package com.garden.life.provider.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.garden.life.commons.beans.UserDetailDTO;
import com.garden.life.commons.domain.RolePermission;
import com.garden.life.commons.domain.User;
import com.garden.life.commons.mapper.UserMapper;
import com.garden.life.commons.service.*;
import org.apache.dubbo.config.annotation.Reference;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.concurrent.CompletableFuture;

/**
 * @author lenvaco
 * @date 2020/3/28 23:42
 */
@Service(version = "${services.versions.user.v1}",timeout = 50000)
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

	@Autowired
	private RoleService roleService;
	@Autowired
	private PermissionService permissionService;
	@Autowired
	private MenuService menuService;
	@Autowired
	private RolePermissionService rolePermissionService;
	@Autowired
	private RoleMenuService roleMenuService;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public User queryUserByUsername(String nickname) {
		Wrapper<User> queryWrapper = new QueryWrapper<User>().likeLeft("nickname", nickname);
		final User user = getOne(queryWrapper);
		System.out.println(user);
		return user;
	}

	@Override
	public UserDetailDTO queryUserDetail(String account, String password) {
		UserDetailDTO user = this.baseMapper.queryUserDetailByAccount(account);
		if(user == null || !bCryptPasswordEncoder.matches(password, user.getPassword()){
			return null;
		}
		CompletableFuture completableFuture = new CompletableFuture()
		return null;
	}

}
