package com.garden.life.auth.web.controller;

import cn.hutool.core.util.IdUtil;
import cn.hutool.http.HttpStatus;
import com.garden.life.auth.beans.AuthenticationInfo;
import com.garden.life.auth.beans.AuthorizationUser;
import com.garden.life.auth.service.JwtUserService;
import com.garden.life.commons.bean.ResponseResult;
import com.garden.life.commons.bean.UserDetailDTO;
import com.garden.life.commons.util.RedisUtils;
import com.garden.life.commons.util.VerifyCodeUtils;
import com.google.common.io.BaseEncoding;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author lenvaco
 * @date 2020/4/21 14:07
 */
@RequestMapping(value = "/auth")
@RestController
@CrossOrigin(origins = "*")
public class AuthTokenController {
    @Resource
    private JwtUserService jwtUserService;
    @Autowired
    private RedisUtils redisUtils;
    private static final int EXPIRE_MINUTE_TIME = 10;
    @GetMapping(value = "user")
    public ResponseResult<Object> getUserDetail() {
        return new ResponseResult<>(HttpStatus.HTTP_OK, "用户请求登录成功", jwtUserService.queryUserDetail("123", "123"));
    }
    @GetMapping(value = "captcha")
    public ResponseResult<Object> getCaptcha() throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        String uuid = IdUtil.simpleUUID();
        String verifyCode = VerifyCodeUtils.drawCaptchaImage(byteArrayOutputStream, 100, 40);
        Map<Object, Object> captchaMap = new HashMap<>(2);
        try{
            captchaMap.put("uuid", uuid);
            captchaMap.put("captchaImage", BaseEncoding.base64().encode(byteArrayOutputStream.toByteArray()));
            redisUtils.setEx(uuid, verifyCode, EXPIRE_MINUTE_TIME, TimeUnit.MINUTES);
            return new ResponseResult<>(HttpStatus.HTTP_OK, "获取验证码成功", captchaMap);
        } finally {
            byteArrayOutputStream.close();
        }
    }

}
