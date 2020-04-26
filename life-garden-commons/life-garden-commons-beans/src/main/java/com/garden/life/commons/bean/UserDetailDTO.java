package com.garden.life.commons.bean;


import com.garden.life.commons.domain.Menu;
import com.garden.life.commons.domain.Permission;
import lombok.*;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
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
	private String roleName;
	private Date updateTime;
	private Date createTime;
	private Set<Permission> permissions;
	private List<MenuDTO> menus;

}
