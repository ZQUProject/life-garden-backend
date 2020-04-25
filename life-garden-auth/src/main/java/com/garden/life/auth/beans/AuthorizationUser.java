package com.garden.life.auth.beans;

import lombok.Data;
import lombok.ToString;

@Data
public class AuthorizationUser {

    private String username;

    @ToString.Exclude
    private String password;

    private String captcha;

    private String uuid = "";

}
