package com.garden.life.provider.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.garden.life.commons.domain.User;
import com.garden.life.commons.mapper.UserMapper;
import com.garden.life.commons.service.UserService;
import org.apache.dubbo.config.annotation.Service;

/**
 * @author lenvaco
 * @date 2020/3/28 23:42
 */
@Service(version = "${services.versions.user.v1}",timeout = 50000)
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
	@Override
	public User queryUserByUsername(String nickname) {
		Wrapper<User> queryWrapper = new QueryWrapper<User>().likeLeft("nickname", nickname);
		final User user = getOne(queryWrapper);
		System.out.println(user);
		return user;
	}
}
