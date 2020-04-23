package com.garden.life.commons.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.garden.life.commons.domain.Menu;

import java.util.Set;

/**
 * <p>
 * 菜单信息表 Mapper 接口
 * </p>
 *
 * @author RunningSnail
 * @since 2020-04-12
 */
public interface MenuMapper extends BaseMapper<Menu> {
	Set<Menu> queryMenuByRoleId(Long roleId);
}
