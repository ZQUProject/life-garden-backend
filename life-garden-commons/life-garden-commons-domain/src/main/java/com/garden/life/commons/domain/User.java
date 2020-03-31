package com.garden.life.commons.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;


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
	private Long userId;
	private String username;
}

