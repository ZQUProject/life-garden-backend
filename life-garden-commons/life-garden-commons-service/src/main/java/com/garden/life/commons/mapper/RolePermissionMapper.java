package com.garden.life.commons.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.garden.life.commons.domain.Permission;
import com.garden.life.commons.domain.RolePermission;

import java.util.Set;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author RunningSnail
 * @since 2020-04-12
 */
public interface RolePermissionMapper extends BaseMapper<RolePermission> {
    Set<Permission> queryPermissionByRoleId(Integer roleId);
}
