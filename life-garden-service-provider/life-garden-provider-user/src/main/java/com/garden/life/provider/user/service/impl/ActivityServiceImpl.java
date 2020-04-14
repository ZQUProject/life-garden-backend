package com.garden.life.provider.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.garden.life.commons.domain.Activity;
import com.garden.life.commons.mapper.ActivityMapper;
import com.garden.life.commons.service.ActivityService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 活动信息表 服务实现类
 * </p>
 *
 * @author RunningSnail
 * @since 2020-04-12
 */
@Service
public class ActivityServiceImpl extends ServiceImpl<ActivityMapper, Activity> implements ActivityService {

}
