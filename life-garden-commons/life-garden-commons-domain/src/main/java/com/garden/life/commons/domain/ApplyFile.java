package com.garden.life.commons.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 申请文件信息表
 * </p>
 * @author RunningSnail
 * @date  2020-04-12
 */
@Data
@TableName("apply_file")
public class ApplyFile implements Serializable {
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    private Long userId;
    private String nickname;
    private Long applyType;
    private String applyReason;
    private Date applyTime;
    private String content;
}
