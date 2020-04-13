package com.garden.life.commons.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 问卷评论信息表
 * </p>
 * @author RunningSnail
 * @date  2020-04-12
 */
@Data
@TableName("questionaire_comment")
public class QuestionaireComment implements Serializable {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private Integer questionaireId;
    private String content;
    private Integer parentId;
    private Integer userId;
    private Date createTime;
}
