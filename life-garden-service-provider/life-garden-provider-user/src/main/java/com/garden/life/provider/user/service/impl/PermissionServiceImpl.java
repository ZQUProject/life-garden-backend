package com.garden.life.provider.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.garden.life.commons.domain.Permission;
import com.garden.life.commons.mapper.PermissionMapper;
import com.garden.life.commons.service.PermissionService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 权限信息表 服务实现类
 * </p>
 *
 * @author RunningSnail
 * @since 2020-04-12
 */
@Service
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper, Permission> implements PermissionService {

}
