package com.garden.life.provider.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.garden.life.commons.bean.MenuDTO;
import com.garden.life.commons.domain.Menu;
import com.garden.life.commons.domain.RoleMenu;
import com.garden.life.commons.mapper.MenuMapper;
import com.garden.life.commons.service.MenuService;
import com.garden.life.commons.service.RoleMenuService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 菜单信息表 服务实现类
 * </p>
 *
 * @author RunningSnail
 * @since 2020-04-12
 */
@Service(version = "${services.versions.user.v1}",timeout = 50000)
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements MenuService {

    @Autowired
    private RoleMenuService roleMenuService;

    @Override
    public MenuDTO queryMenuByMenuId(Integer menuId) {
        return MenuDTO.toDTO(this.getById(menuId), null);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateMenu(MenuDTO menuDTO) {
        Menu menu = new Menu();
        BeanUtils.copyProperties(menuDTO, menu);
        menu.setCreateTime(null);
        this.updateById(menu);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveMenu(MenuDTO menuDTO) {
        Menu menu = new Menu();
        BeanUtils.copyProperties(menuDTO, menu);
        menu.setId(null);
        menu.setCreateTime(Date.from(Instant.now()));
        this.save(menu);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteMenuByMenuId(Integer menuId) {
        Wrapper<RoleMenu> wrapper = new UpdateWrapper<RoleMenu>().eq("menu_id", menuId);
        //删除role和menu的对应关系
        roleMenuService.remove(wrapper);
        this.removeById(menuId);
    }

    @Override
    public List<MenuDTO> queryAllMenuTree() {
        return buildTree(this.list());
    }

    //该参数表示菜单主节点id
    private static final String ROOT_ID = "0";

    @Override
    public List<MenuDTO> buildTree(List<Menu> menuList) {
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
