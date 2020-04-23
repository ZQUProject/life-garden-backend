package com.garden.life.commons.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.garden.life.commons.domain.Permission;

import java.util.Set;

/**
 * <p>
 * 权限信息表 服务类
 * </p>
 *
 * @author RunningSnail
 * @since 2020-04-12
 */
public interface PermissionService extends IService<Permission> {

	Set<Permission> queryPermssionByRoleId(Long roleId);
}
