package com.garden.life.commons.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.garden.life.commons.bean.UserDetailDTO;
import com.garden.life.commons.domain.User;

/**
 * @author lenvaco
 * @date 2020/3/28 23:48
 */
public interface UserService extends IService<User> {

	User queryUserByUsername(String nickname);

	UserDetailDTO queryUserDetail(String account, String password);
}
