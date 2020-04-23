package com.garden.life.provider.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.garden.life.commons.domain.Permission;
import com.garden.life.commons.domain.RolePermission;
import com.garden.life.commons.mapper.RolePermissionMapper;
import com.garden.life.commons.service.RolePermissionService;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author RunningSnail
 * @since 2020-04-12
 */
@Service
public class RolePermissionServiceImpl extends ServiceImpl<RolePermissionMapper, RolePermission> implements RolePermissionService {

    @Override
    public Set<Permission> queryPermssionByRoleId(Long roleId) {
        return null;
    }
}
