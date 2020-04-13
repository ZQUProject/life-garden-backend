package com.garden.life.commons.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 投票活动详情表
 * </p>
 * @author RunningSnail
 * @date  2020-04-12
 */
@Data
@TableName("vote_detail")
public class VoteDetail implements Serializable {
    private Long itemId;
    private Long userId;
    private Integer voteCount;
    private Date voteTime;
}
