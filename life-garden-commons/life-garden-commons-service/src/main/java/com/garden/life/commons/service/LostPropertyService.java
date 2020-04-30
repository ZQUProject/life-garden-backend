package com.garden.life.commons.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.garden.life.commons.domain.LostProperty;

import java.util.List;

/**
 * <p>
 * 失物信息表 服务类
 * </p>
 *
 * @author RunningSnail
 * @since 2020-04-12
 */
public interface LostPropertyService extends IService<LostProperty> {

    List<LostProperty> queryLostPropertyByLostPropertyType(Long type);

}
