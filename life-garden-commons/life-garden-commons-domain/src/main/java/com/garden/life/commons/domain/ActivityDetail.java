package com.garden.life.commons.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 活动报名详情表
 * </p>
 * @author RunningSnail
 * @date  2020-04-12
 */
@Data
@TableName("activity_detail")
public class ActivityDetail implements Serializable {
    private Long activityId;
    private Long userId;
    private Date createTime;
}
