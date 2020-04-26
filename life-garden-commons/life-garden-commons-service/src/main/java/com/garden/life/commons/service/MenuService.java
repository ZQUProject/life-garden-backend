package com.garden.life.commons.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.garden.life.commons.bean.MenuDTO;
import com.garden.life.commons.bean.ResponseResult;
import com.garden.life.commons.domain.Menu;

import java.util.List;

/**
 * <p>
 * 菜单信息表 服务类
 * </p>
 *
 * @author RunningSnail
 * @since 2020-04-12
 */
public interface MenuService extends IService<Menu> {
    /**
     * 将所有menuList构成一颗MenuDTO类型的List树
     * @param menuList 菜单
     * @return 构建成的菜单List树
     */
    List<MenuDTO> buildTree(List<Menu> menuList);

    /**
     * 查询所有的Menu并构成多棵树
     * @return 构建成的菜单List树
     */
    List<MenuDTO> queryAllMenuTree();

    /**
     * 根据菜单id查询菜单详情
     * @param menuId 菜单id
     * @return 菜单具体信息
     */
    MenuDTO queryMenuByMenuId(Integer menuId);

    /**
     * 更新菜单信息
     * @param menuDTO 菜单具体信息
     */
    void updateMenu(MenuDTO menuDTO);
    /**
     * 保存菜单
     * @param menuDTO 菜单详情
     */
    void saveMenu(MenuDTO menuDTO);

    /**
     * 删除菜单信息
     * @param id 菜单主键
     */
    void deleteMenuByMenuId(Integer menuId);
}
