package com.garden.life.commons.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 问卷信息表
 * </p>
 * @author RunningSnail
 * @date  2020-04-12
 */
@Data
@TableName("questionaire")
public class Questionaire implements Serializable {
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    private String title;
    private String status;
    private Long checkerId;
    private String content;
    private Integer type;
    private Date createTime;
}
