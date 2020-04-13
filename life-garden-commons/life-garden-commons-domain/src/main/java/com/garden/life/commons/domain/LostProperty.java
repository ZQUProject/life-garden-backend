package com.garden.life.commons.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 失物信息表
 * </p>
 * @author RunningSnail
 * @date  2020-04-12
 */
@Data
@TableName("lost_property")
public class LostProperty implements Serializable {
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    private Long userId;
    private String nickname;
    private Long type;
    private String content;
    private String contractWay;
    private Date createTime;
}
