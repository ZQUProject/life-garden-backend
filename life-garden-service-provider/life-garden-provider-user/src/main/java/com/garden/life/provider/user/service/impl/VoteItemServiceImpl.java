package com.garden.life.provider.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.garden.life.commons.domain.VoteItem;
import com.garden.life.commons.mapper.VoteItemMapper;
import com.garden.life.commons.service.VoteItemService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 投票选项信息表 服务实现类
 * </p>
 *
 * @author RunningSnail
 * @since 2020-04-12
 */
@Service
public class VoteItemServiceImpl extends ServiceImpl<VoteItemMapper, VoteItem> implements VoteItemService {

}