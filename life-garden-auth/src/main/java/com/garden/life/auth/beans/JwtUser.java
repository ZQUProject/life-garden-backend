package com.garden.life.auth.beans;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author lenvaco
 * @date 2020/4/19 21:16
 */
@Data
public class JwtUser implements Serializable {
	private static final long serialVersionUID = 691870694906061759L;

	private Date updateTime;
}
