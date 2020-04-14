package com.garden.life.provider.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.garden.life.commons.domain.Vote;
import com.garden.life.commons.mapper.VoteMapper;
import com.garden.life.commons.service.VoteService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 投票信息表 服务实现类
 * </p>
 *
 * @author RunningSnail
 * @since 2020-04-12
 */
@Service
public class VoteServiceImpl extends ServiceImpl<VoteMapper, Vote> implements VoteService {

}
