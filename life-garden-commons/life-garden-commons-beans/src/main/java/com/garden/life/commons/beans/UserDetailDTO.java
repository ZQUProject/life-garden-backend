package com.garden.life.commons.beans;


import com.garden.life.commons.domain.Permission;
import com.garden.life.commons.domain.Role;
import lombok.*;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

/**
 * @author lenvaco
 * @date 2020/4/19 22:27
 */

@Data
public class UserDetailDTO implements Serializable {
	private static final long serialVersionUID = 5988689497872135730L;

	private Long id;
	private String account;
	private String nickname;
	private String password;
	private Integer classId;
	private String className;
	private Integer roleId;
	private Date updateTime;
	private Date createTime;
	private Set<Role> roles;
	private Set<Permission> permissions;
}
