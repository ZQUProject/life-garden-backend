package com.garden.life.provider.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.garden.life.commons.bean.MenuDTO;
import com.garden.life.commons.domain.Menu;
import com.garden.life.commons.domain.RoleMenu;
import com.garden.life.commons.mapper.RoleMenuMapper;
import com.garden.life.commons.service.RoleMenuService;
import com.garden.life.commons.util.MapperUtils;
import com.garden.life.commons.util.RedisUtils;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

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

    private final String CACHE_PREFIX = "ROLE_MENU_";

    @Autowired
    private RedisUtils redisUtils;

    @Override
    public List<MenuDTO> queryMenuByRoleId(Integer roleId) {
        List<MenuDTO> menuDTOs = null;
        //从缓存中查询菜单
        menuDTOs = MapperUtils.string2Obj(redisUtils.get(CACHE_PREFIX + roleId), List.class);
        //缓存中查不到就从数据库查询
        if (menuDTOs == null ){
            menuDTOs = buildTree(this.getBaseMapper().queryMenuByRoleId(roleId));
        }
        return menuDTOs;
    }

    private static final String ROOT_ID = "0";
    private List<MenuDTO> buildTree(List<Menu> menuList) {
        if(menuList == null) {
            return null;
        }
        List<MenuDTO>menuDTOList = menuList.stream().sorted(Comparator.comparing(Menu::getSort))
                .collect(Collectors.toList()).stream()
                .map(menu -> MenuDTO.toDTO(menu, null))
                .collect(Collectors.toList());
        List<MenuDTO> trees = new ArrayList<>();
        for (MenuDTO menuDTO: menuDTOList) {
            //主节点选取
            if (ROOT_ID.equals(menuDTO.getParentId().toString())){
                trees.add(menuDTO);
            }
            //找到当前节点的子节点
            for (MenuDTO mdt : menuDTOList){
                if(mdt.getParentId().equals(menuDTO.getId())) {
                    if(menuDTO.getChildren() == null ) {
                        menuDTO.setChildren(new ArrayList<>());
                    }
                    menuDTO.getChildren().add(mdt);
                }
            }
        }
        return trees;
    }
}
