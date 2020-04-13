package com.garden.life.commons.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 活动信息表
 * </p>
 * @author RunningSnail
 * @date  2020-04-12
 */
@Data
@TableName("activity")
public class Activity implements Serializable {
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    private Long userId;
    private String nickname;
    private String title;
    private String content;
    private Long checkerId;
    private Integer status;
    private Integer scopeId;
    private Integer userLimit;
    private String socpeType;
    private String location;
    private Date startTime;
    private Date endTime;
    private Date createTime;
}
