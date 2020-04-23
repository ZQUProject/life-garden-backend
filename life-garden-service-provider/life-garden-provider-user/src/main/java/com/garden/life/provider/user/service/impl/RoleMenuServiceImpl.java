package com.garden.life.provider.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.garden.life.commons.domain.Menu;
import com.garden.life.commons.domain.RoleMenu;
import com.garden.life.commons.mapper.RoleMenuMapper;
import com.garden.life.commons.service.RoleMenuService;
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
public class RoleMenuServiceImpl extends ServiceImpl<RoleMenuMapper, RoleMenu> implements RoleMenuService {

    @Override
    public Set<Menu> queryMenuByRoleId(Integer roleId) {
        return this.getBaseMapper().queryMenuByRoleId(roleId);
    }
}
