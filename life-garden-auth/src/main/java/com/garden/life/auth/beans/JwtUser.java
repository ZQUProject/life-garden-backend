package com.garden.life.auth.beans;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.garden.life.commons.bean.MenuDTO;
import com.garden.life.commons.bean.UserDetailDTO;
import com.garden.life.commons.domain.Menu;
import com.garden.life.commons.domain.Permission;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author lenvaco
 * @date 2020/4/19 21:16
 */
@NoArgsConstructor
@Getter
@Setter
public class JwtUser implements UserDetails {
	private static final long serialVersionUID = 691870694906061759L;

	private String account;
	private String nickname;
	@JsonIgnore
	private String password;
	private String className;
	private String roleName;
	private Set<Permission> permissions;
	private List<MenuDTO> menus;
	@JsonIgnore
	private Date updateTime;
	@JsonIgnore
	private Date createTime;
	public JwtUser(UserDetailDTO userDetailDTO){
		this.account = userDetailDTO.getAccount();
		this.nickname = userDetailDTO.getNickname();
		this.password = userDetailDTO.getPassword();
		this.className = userDetailDTO.getClassName();
		this.roleName = userDetailDTO.getRoleName();
		this.permissions = userDetailDTO.getPermissions();
		this.menus = userDetailDTO.getMenus();
		this.updateTime = userDetailDTO.getUpdateTime();
		this.createTime = userDetailDTO.getCreateTime();
	}
	@JsonIgnore
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return permissions.stream().sorted()
				.map(permission -> new SimpleGrantedAuthority(permission.getName()))
				.collect(Collectors.toList());
	}
	@JsonIgnore
	@Override
	public String getUsername() {
		return account;
	}

	@JsonIgnore
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}
	@JsonIgnore
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}
	@JsonIgnore
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}
	@JsonIgnore
	@Override
	public boolean isEnabled() {
		return true;
	}
}
