package com.garden.life.auth.web.controller;

import cn.hutool.http.HttpStatus;
import com.garden.life.auth.beans.AuthenticationInfo;
import com.garden.life.auth.beans.AuthorizationUser;
import com.garden.life.auth.service.JwtUserService;
import com.garden.life.commons.bean.ResponseResult;
import com.garden.life.commons.bean.UserDetailDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author lenvaco
 * @date 2020/4/21 14:07
 */
@RequestMapping(value = "/auth")
@RestController()
public class AuthTokenController {
    @Resource
    private JwtUserService jwtUserService;

    @GetMapping(value = "user")
    public ResponseResult<AuthenticationInfo> getUserDetail(){

        return new ResponseResult<>(HttpStatus.HTTP_OK, "用户请求登录成功", jwtUserService.queryUserDetail("123", "123"));
    }

}
