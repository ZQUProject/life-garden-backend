package com.garden.life.consumer.user.controller;

import cn.hutool.http.HttpStatus;
import com.garden.life.commons.bean.MenuDTO;
import com.garden.life.commons.bean.ResponseResult;
import com.garden.life.commons.service.MenuService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
public class MenuController {

    @Resource
    private MenuService menuService;


    @GetMapping(value = "menu/{menuId}")
//    @PreAuthorize("hasAnyRole('ADMIN','MENU_ALL','MENU_CREATE','MENU_EDIT','ROLES_ALL','ROLES_SELECT')")
    public ResponseResult<Object> getMenu(@PathVariable(name="menuId") Integer menuId) {
        return new ResponseResult<Object>(HttpStatus.HTTP_OK, "请求菜单成功", menuService.queryMenuByMenuId(menuId));
    }


    @GetMapping(value = "menu/all")
//    @PreAuthorize("hasAnyRole('ADMIN','MENU_ALL','MENU_CREATE','MENU_EDIT','ROLES_ALL','ROLES_SELECT')")
    public ResponseResult<Object> getAllMenuDetail() {
        return new ResponseResult<Object>(HttpStatus.HTTP_OK, "请求全部菜单成功", menuService.queryAllMenuTree());
    }

    @PostMapping(value = "menu")
    public ResponseResult<Object> saveMenu(@Validated @RequestBody MenuDTO menuDTO){
        menuService.saveMenu(menuDTO);
        return new ResponseResult<>(HttpStatus.HTTP_OK, "添加菜单成功");
    }

    @PutMapping(value = "menu/{menuId}")
        public ResponseResult<Object> updateMenu(@PathVariable(name="menuId") Integer menuId,@Validated @RequestBody MenuDTO menuDTO){
        menuDTO.setId(menuId);
        menuService.updateMenu(menuDTO);
        return new ResponseResult<>(HttpStatus.HTTP_OK, "更新菜单成功");
    }

    @DeleteMapping(value = "menu/{menuId}")
    public ResponseResult<Object> deleteMenu(@PathVariable(name="menuId") Integer menuId) {
        menuService.deleteMenuByMenuId(menuId);
        return new ResponseResult<>(HttpStatus.HTTP_OK, "删除菜单成功");
    }
}
