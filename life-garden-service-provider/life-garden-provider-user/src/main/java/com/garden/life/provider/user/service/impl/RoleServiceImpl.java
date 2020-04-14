package com.garden.life.provider.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.garden.life.commons.domain.Role;
import com.garden.life.commons.mapper.RoleMapper;
import com.garden.life.commons.service.RoleService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 角色信息表 服务实现类
 * </p>
 *
 * @author RunningSnail
 * @since 2020-04-12
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {

}
