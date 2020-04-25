package com.garden.life.provider.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.garden.life.commons.domain.Permission;
import com.garden.life.commons.domain.RolePermission;
import com.garden.life.commons.mapper.RolePermissionMapper;
import com.garden.life.commons.service.RolePermissionService;
import com.garden.life.commons.util.MapperUtils;
import com.garden.life.commons.util.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
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

    private final String CACHE_PREFIX = "ROLE_PERMISSION_";

    @Autowired
    private RedisUtils redisUtils;

    @Override
    public Set<Permission> queryPermssionByRoleId(Integer roleId) {
        Set<Permission> permissions = null;
        //从缓存中查询菜单
        permissions = MapperUtils.string2Obj(redisUtils.get(CACHE_PREFIX + roleId), Set.class);
        //缓存中查不到就从数据库查询
        if (permissions == null ){
            permissions = this.getBaseMapper().queryPermissionByRoleId(roleId);
        }
        return permissions;

    }
}
