package com.garden.life.consumer.user.controller;

import cn.hutool.http.HttpStatus;
import com.garden.life.commons.bean.ResponseResult;
import com.garden.life.commons.domain.LostProperty;
import com.garden.life.commons.service.LostPropertyService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 失物信息控制类
 * </p>
 *
 * @author YangShuKai
 * @date 2020/4/27 16:44
 */
@RestController
public class LostPropertyController {

    @Reference(version = "${services.versions.lostProperty.v1}", lazy = true, timeout = 3000)
    private LostPropertyService lostPropertyService;

    /**
     * 获取所有失物信息，返回json数据
     *
     * @return 返回list类型的LostProperty信息
     */
    @GetMapping(value = "lostProperty/all")
    public List<LostProperty> getAllLostProperty() {
        return lostPropertyService.list();
    }

    /**
     * 根据失物类型来查询失物信息
     *
     * @param type 失物类型（捡到失物、寻找失物）
     * @return 返回list类型的LostProperty信息
     */
    @GetMapping(value = "lostProperty/{type}")
    public List<LostProperty> getLostPropertyByType(@PathVariable("type") Long type) {
        return lostPropertyService.queryLostPropertyByLostPropertyType(type);
    }

    /**
     * 根据id删除失物信息
     *
     * @param id 失物信息的id
     * @return 返回删除结果
     */
    @DeleteMapping(value = "lostProperty/{id}")
    public ResponseResult<Object> deleteLostProperty(@PathVariable("id") Integer id) {
        return new ResponseResult<>(HttpStatus.HTTP_OK, "删除失物信息成功", lostPropertyService.removeById(id));
    }

    /**
     * 添加失物信息
     *
     * @param lostProperty 要保存的失物信息
     * @return 返回保存结果
     */
    @PostMapping(value = "lostProperty/save")
    public ResponseResult<Object> saveLostProperty(LostProperty lostProperty) {
        return new ResponseResult<>(HttpStatus.HTTP_OK, "添加失物信息成功", lostPropertyService.save(lostProperty));
    }

    /**
     * 查询一个失物信息
     *
     * @param id 失物信息id
     * @return 返回查询结果
     */
    @GetMapping(value = "lostProperty/{id}")
    public LostProperty getOneLostProperty(@PathVariable("id") Integer id) {
        return lostPropertyService.getById(id);
    }

    /**
     * 修改失物信息
     *
     * @param lostProperty 新的失物信息即修改后要保存的失物信息
     * @return 返回修改结果
     */
    @PutMapping(value = "lostProperty/update")
    public ResponseResult<Object> updateLostProperty(LostProperty lostProperty) {
        return new ResponseResult<>(HttpStatus.HTTP_OK, "修改失物信息成功", lostPropertyService.updateById(lostProperty));
    }
}
