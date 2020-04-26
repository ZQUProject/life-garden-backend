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
    public List<Menu> queryMenuByRoleId(Integer roleId) {
        List<Menu> menus = null;
        //从缓存中查询菜单
        menus = MapperUtils.string2Obj(redisUtils.get(CACHE_PREFIX + roleId), List.class);
        //缓存中查不到就从数据库查询
        if (menus == null ){
            menus = this.getBaseMapper().queryMenuByRoleId(roleId);
        }
        return menus;
    }


}
