package com.garden.life.commons.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.garden.life.commons.bean.MenuDTO;
import com.garden.life.commons.domain.Menu;
import com.garden.life.commons.domain.RoleMenu;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author RunningSnail
 * @since 2020-04-12
 */
public interface RoleMenuService extends IService<RoleMenu> {

    /**
     * 根据角色主键id查找对应的菜单
     * @param roleId  角色主键id
     * @return 菜单集
     */
    List<Menu> queryMenuByRoleId(Integer roleId);
}
