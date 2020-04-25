package com.garden.life.auth.service;

import com.garden.life.auth.beans.AuthenticationInfo;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * @author lenvaco
 * @date 2020/4/19 13:42
 */

public interface JwtUserService extends UserDetailsService {
    AuthenticationInfo queryUserDetail(String account, String password);
}
