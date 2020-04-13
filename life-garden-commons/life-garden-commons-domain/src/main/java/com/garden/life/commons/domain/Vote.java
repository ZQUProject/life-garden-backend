package com.garden.life.commons.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 投票信息表
 * </p>
 * @author RunningSnail
 * @date  2020-04-12
 */
@Data
@TableName("vote")
public class Vote implements Serializable {
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    private String title;
    private Integer status;
    private Long checkerId;
    private String content;
    private Long userId;
    private Date startTime;
    private Date endTime;
    private Date createTime;
}
