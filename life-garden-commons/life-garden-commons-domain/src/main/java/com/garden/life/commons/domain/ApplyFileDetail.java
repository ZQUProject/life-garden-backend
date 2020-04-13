package com.garden.life.commons.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 申请文件日志信息表
 * </p>
 * @author RunningSnail
 * @date  2020-04-12
 */
@Data
@TableName("apply_file_detail")
public class ApplyFileDetail implements Serializable {
    @TableId(value = "file_id", type = IdType.AUTO)
    private Long fileId;
    private Long userId;
    private Integer status;
    private Long checkerId;
    private Date createTime;
}
