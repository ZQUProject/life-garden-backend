package com.garden.life.provider.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.garden.life.commons.domain.LostProperty;
import com.garden.life.commons.mapper.LostPropertyMapper;
import com.garden.life.commons.service.LostPropertyService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 失物信息表 服务实现类
 * </p>
 *
 * @author RunningSnail
 * @since 2020-04-12
 */
@Slf4j
@Service(version = "${services.versions.lostProperty.v1}", timeout = 50000)
public class LostPropertyServiceImpl extends ServiceImpl<LostPropertyMapper, LostProperty> implements LostPropertyService {

    @Resource
    private LostPropertyService lostPropertyService;

    /**
     * 根据失物类型来查询失物信息
     *
     * @param type 失物类型（捡到失物、寻找失物）
     * @return 返回list类型的LostProperty信息
     */
    @Override
    public List<LostProperty> queryLostPropertyByLostPropertyType(Long type) {
        Wrapper<LostProperty> queryWrapper = new QueryWrapper<LostProperty>().likeLeft("type", type);
        return lostPropertyService.list(queryWrapper);
    }
}
