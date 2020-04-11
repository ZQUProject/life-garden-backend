package com.garden.life.commons.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;


/**
 * <p>
 * 系统用户表
 * </p>
 * @author lenvaco
 * @date 2020/3/28 19:58
 */
@Data
@TableName("user")
public class User implements Serializable {
	@TableId(type = IdType.INPUT)
	private Long id;
	private String account;
	private String nickname;
	private String password;
	private Integer class_id;
	private Integer role_id;
	private Date updateTime;
	private Date createTime;
}

