package com.garden.life.commons.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.garden.life.commons.domain.Permission;
import com.garden.life.commons.domain.RolePermission;

import java.util.Set;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author RunningSnail
 * @since 2020-04-12
 */
public interface RolePermissionService extends IService<RolePermission> {

    /**
     * 根据角色主键id查找对应的角色权限
     * @param roleId  角色主键id
     * @return 权限集
     */
    Set<Permission> queryPermssionByRoleId(Integer roleId);
}
