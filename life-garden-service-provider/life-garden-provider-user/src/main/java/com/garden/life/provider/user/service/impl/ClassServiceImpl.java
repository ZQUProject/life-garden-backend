package com.garden.life.provider.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.garden.life.commons.domain.Class;
import com.garden.life.commons.mapper.ClassMapper;
import com.garden.life.commons.service.ClassService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 班级信息表 服务实现类
 * </p>
 *
 * @author RunningSnail
 * @since 2020-04-12
 */
@Service
public class ClassServiceImpl extends ServiceImpl<ClassMapper, Class> implements ClassService {

}
