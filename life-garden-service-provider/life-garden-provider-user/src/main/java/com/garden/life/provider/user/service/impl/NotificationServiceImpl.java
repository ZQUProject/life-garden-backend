package com.garden.life.provider.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.garden.life.commons.domain.Notification;
import com.garden.life.commons.mapper.NotificationMapper;
import com.garden.life.commons.service.NotificationService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 通知信息表 服务实现类
 * </p>
 *
 * @author RunningSnail
 * @since 2020-04-12
 */
@Service
public class NotificationServiceImpl extends ServiceImpl<NotificationMapper, Notification> implements NotificationService {

}
