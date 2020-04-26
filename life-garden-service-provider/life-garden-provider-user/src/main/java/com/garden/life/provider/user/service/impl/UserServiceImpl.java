package com.garden.life.provider.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.garden.life.commons.bean.MenuDTO;
import com.garden.life.commons.bean.UserDetailDTO;
import com.garden.life.commons.domain.Menu;
import com.garden.life.commons.domain.User;
import com.garden.life.commons.mapper.UserMapper;
import com.garden.life.commons.service.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.annotation.Resource;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author lenvaco
 * @date 2020/3/28 23:42
 */
@Slf4j
@Service(version = "${services.versions.user.v1}",timeout = 50000)
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

	@Resource
	private RoleService roleService;
	@Resource
	private PermissionService permissionService;
	@Resource
	private MenuService menuService;
	@Resource
	private RolePermissionService rolePermissionService;
	@Resource
	private RoleMenuService roleMenuService;
	@Resource
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Resource(name = "taskThreadPool")
	private ThreadPoolExecutor taskThreadPool;

	@Override
	public User queryUserByUsername(String nickname) {
		Wrapper<User> queryWrapper = new QueryWrapper<User>().likeLeft("nickname", nickname);
		final User user = getOne(queryWrapper);
		return user;
	}

    private final int ASYNC_MAX_WAIT = 5;
	@Override
	public UserDetailDTO queryUserDetail(String account, String password) {
		//根据账号密码查询用户
		UserDetailDTO user = this.baseMapper.queryUserDetailByAccount(account);
		if(user == null || !bCryptPasswordEncoder.matches(password, user.getPassword())){
			return null;
		}
		//异步查询菜单
		CompletableFuture<List<MenuDTO>> menuFuture = CompletableFuture.supplyAsync(
			()->{
				List<Menu> menus = roleMenuService.queryMenuByRoleId(user.getRoleId());
				return menuService.buildTree(menus);
			},
			taskThreadPool
		).exceptionally(throwable -> {
			//异常处理
			log.warn("用户{}查询菜单过程出现异常", user.getId());
			return null;
		});
		user.setPermissions(rolePermissionService.queryPermssionByRoleId(user.getRoleId()));
		try {
			user.setMenus(menuFuture.get(ASYNC_MAX_WAIT, TimeUnit.SECONDS));
		} catch (Exception ex) {
			//记录异常
			log.warn("用户{}查询菜单返回出现异常", user.getId());
		}
		return user;
	}

}
