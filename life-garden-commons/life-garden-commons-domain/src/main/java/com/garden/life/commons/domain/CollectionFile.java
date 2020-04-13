package com.garden.life.commons.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 文件收集信息表
 * </p>
 * @author RunningSnail
 * @date  2020-04-12
 */
@Data
@TableName("collection_file")
public class CollectionFile implements Serializable {
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    private Long userId;
    private String nickname;
    private Long checkerId;
    private String content;
    private Integer status;
    private String templatePath;
    private Integer scopeId;
    private Integer scopeType;
    private Date endTime;
    private Date createTime;
}
