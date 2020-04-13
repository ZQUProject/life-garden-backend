package com.garden.life.commons.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 * 投票选项信息表
 * </p>
 * @author RunningSnail
 * @date  2020-04-12
 */
@Data
@TableName("vote_item")
public class VoteItem implements Serializable {
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    private String itemContent;
    private String itemAddition;
    private Long voteId;
}
