package com.garden.life.commons.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.garden.life.commons.domain.Menu;
import com.garden.life.commons.domain.RoleMenu;

import java.util.Set;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author RunningSnail
 * @since 2020-04-12
 */
public interface RoleMenuMapper extends BaseMapper<RoleMenu> {
    Set<Menu> queryMenuByRoleId(Integer roleId);
}
